/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.examen.examen.business.impl;

import co.poli.examen.examen.business.IProductoBusiness;
import co.poli.examen.examen.dao.IProductoDao;
import co.poli.examen.examen.model.Producto;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeisonvs
 */
@Service
public class ProductoBusinessImpl implements IProductoBusiness{

    @Autowired
    IProductoDao daoProducto;
    
    @Override
    public Producto getProducto(String id) {
        return daoProducto.getProducto(id);
    }

    @Override
    public ArrayList<Producto> getProductos() {
        return daoProducto.getProductos();
    }

    @Override
    public boolean crearProducto(Producto producto) {
        return daoProducto.crearProducto(producto);
    }

    @Override
    public boolean modificarProducto(Producto producto) {
        return daoProducto.modificarProducto(producto);
    }

    @Override
    public boolean eliminarProducto(String idProducto) {
        return daoProducto.eliminarProducto(idProducto);
    }
    
}
