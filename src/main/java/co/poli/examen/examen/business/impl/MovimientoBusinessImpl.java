/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.examen.examen.business.impl;

import co.poli.examen.examen.business.IMovimientoBusiness;
import co.poli.examen.examen.dao.IMovimientoDao;
import co.poli.examen.examen.dao.IProductoDao;
import co.poli.examen.examen.model.Movimiento;
import co.poli.examen.examen.model.Producto;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeisonvs
 */
@Service
public class MovimientoBusinessImpl implements IMovimientoBusiness {

    @Autowired
    IMovimientoDao daoMovimiento;

    @Autowired
    IProductoDao daoProducto;

    @Override
    public Movimiento getMovimiento(String id) {
        return daoMovimiento.getMovimiento(id);
    }

    @Override
    public ArrayList<Movimiento> getMovimientos() {
        return daoMovimiento.getMovimientos();
    }

    @Override
    public boolean crearMovimiento(Movimiento movimiento) {
        if (movimiento == null || (movimiento.getTipoMovimiento() != Movimiento.TIPO_ENTRADA && movimiento.getTipoMovimiento() != Movimiento.TIPO_SALIDA)) {
            return false;
        }
        if (daoMovimiento.getMovimiento(movimiento.getIdMovimiento()) != null) {
            return false;
        }
        Producto producto = movimiento.getProducto();
        if (producto == null) {
            return false;
        }
        boolean result = false;
        switch (movimiento.getTipoMovimiento()) {
            case Movimiento.TIPO_ENTRADA: {
                if (movimiento.getPrecio() <= 0) {
                    result = false;
                } else {
                    Double total = producto.getExistencia() + movimiento.getCantidad();
                    if (total >= 0) {
                        producto.setExistencia(total);
                        daoProducto.modificarProducto(producto);
                        daoMovimiento.crearMovimiento(movimiento);
                        result = true;
                    } else {
                        result = false;
                    }
                }
            }
            case Movimiento.TIPO_SALIDA: {
                if (movimiento.getCantidad() > producto.getExistencia()) {
                    result = false;
                } else {
                    Double total = producto.getExistencia() - movimiento.getCantidad();
                    if (total >= 0) {
                        movimiento.setPrecio(0d);
                        producto.setExistencia(total);
                        daoProducto.modificarProducto(producto);
                        daoMovimiento.crearMovimiento(movimiento);
                        result = true;
                    } else {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public boolean modificarMovimiento(Movimiento movimiento) {
        if (movimiento == null) {
            return false;
        }
        Movimiento movimientoActual = daoMovimiento.getMovimiento(movimiento.getIdMovimiento());
        if (movimientoActual == null) {
            return false;
        }
        Producto producto = movimiento.getProducto();
        if (producto == null) {
            return false;
        }
        boolean result = false;
        switch (movimiento.getTipoMovimiento()) {
            case Movimiento.TIPO_ENTRADA: {
                if (movimiento.getPrecio() <= 0) {
                    result = false;
                } else {
                    Double total = producto.getExistencia() + (movimiento.getCantidad() - movimientoActual.getCantidad());
                    if (total >= 0) {
                        producto.setExistencia(total);
                        daoProducto.modificarProducto(producto);
                        daoMovimiento.modificarMovimiento(movimiento);
                        result = true;
                    } else {
                        result = false;
                    }
                }
            }
            case Movimiento.TIPO_SALIDA: {
                if (movimiento.getCantidad() > producto.getExistencia()) {
                    result = false;
                } else {
                    Double total = producto.getExistencia() - (movimiento.getCantidad() - movimientoActual.getCantidad());
                    if (total >= 0) {
                        movimiento.setPrecio(0d);
                        producto.setExistencia(total);
                        daoProducto.modificarProducto(producto);
                        daoMovimiento.modificarMovimiento(movimiento);
                        result = true;
                    } else {
                        result = false;
                    }
                }
            }
            default: {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean eliminarMovimiento(String idMovimiento) {
        Movimiento movimientoActual = daoMovimiento.getMovimiento(idMovimiento);
        if (movimientoActual == null) {
            return false;
        }
        Producto producto = movimientoActual.getProducto();
        if (producto == null) {
            return false;
        }
        boolean result = false;
        switch (movimientoActual.getTipoMovimiento()) {
            case Movimiento.TIPO_ENTRADA: {
                Double total = producto.getExistencia() - movimientoActual.getCantidad();
                if (total >= 0) {
                    producto.setExistencia(total);
                    daoProducto.modificarProducto(producto);
                    daoMovimiento.eliminarMovimiento(idMovimiento);
                    result = true;
                } else {
                    result = false;
                }
            }
            case Movimiento.TIPO_SALIDA: {
                Double total = producto.getExistencia() + movimientoActual.getCantidad();
                if (total >= 0) {
                    producto.setExistencia(total);
                    daoProducto.modificarProducto(producto);
                    daoMovimiento.eliminarMovimiento(idMovimiento);
                    result = true;
                } else {
                    result = false;

                }
            }
            default: {
                result = false;
            }
        }
        return result;
    }

    @Override
    public Double valorDelInventario() {
        ArrayList<Producto> productos = daoProducto.getProductos();
        ArrayList<Movimiento> movimientos = daoMovimiento.getMovimientos();
        Double totalInventario = 0d;
        for (Producto producto : productos) {
            double totalProducto = 0d;
            int cantidadEntradas = 0;
            for (Movimiento movimiento : movimientos) {
                if (movimiento.getTipoMovimiento() == Movimiento.TIPO_ENTRADA) {
                    totalProducto += (movimiento.getCantidad() * movimiento.getPrecio());
                    cantidadEntradas++;
                }
            }
            if (cantidadEntradas > 0) {
                totalProducto = totalProducto / cantidadEntradas;
            }
            totalInventario += (totalProducto * producto.getExistencia());
        }
        return totalInventario;
    }

}
