/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.examen.examen.model;

import java.util.Objects;

/**
 *
 * @author jeisonvs
 */
public class Movimiento {

    public final static int TIPO_ENTRADA = 0;
    public final static int TIPO_SALIDA = 1;
    
    String idMovimiento;
    Producto producto;
    Integer tipoMovimiento;
    Double Cantidad;
    Double Precio;

    public Movimiento() {
    }

    public Movimiento(String idMovimiento, Producto producto, Integer tipoMovimiento, Double Cantidad, Double Precio) {
        this.idMovimiento = idMovimiento;
        this.producto = producto;
        this.tipoMovimiento = tipoMovimiento;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
    }

    public String getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(String idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Integer tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idMovimiento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimiento other = (Movimiento) obj;
        if (!Objects.equals(this.idMovimiento, other.idMovimiento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "idMovimiento=" + idMovimiento + ", producto=" + producto + ", tipoMovimiento=" + tipoMovimiento + ", Cantidad=" + Cantidad + ", Precio=" + Precio + '}';
    }
    
    
    
}
