/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.examen.examen.dao.impl;

import co.poli.examen.examen.dao.IProductoDao;
import co.poli.examen.examen.data.ProductoData;
import co.poli.examen.examen.model.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jeisonvs
 */
@Repository
public class ProductoDaoImpl implements IProductoDao {

    @Override
    public Producto getProducto(String id) {
        Producto producto = null;

        for (Producto product : ProductoData.getProductos()) {
            if (product.getIdProducto().equals(id)) {
                producto = product;
                break;
            }
        }
        return producto;
    }

    @Override
    public ArrayList<Producto> getProductos() {
        return ProductoData.getProductos();
    }

    @Override
    public boolean crearProducto(Producto producto) {
        return ProductoData.getProductos().add(producto);
    }

    @Override
    public boolean modificarProducto(Producto producto) {
        List<Producto> productos = ProductoData.getProductos();
        int indexProducto = productos.lastIndexOf(producto);
        boolean exist = indexProducto != -1;
        if (exist) {
            productos.set(indexProducto, producto);
        }
        return exist;
    }

    @Override
    public boolean eliminarProducto(String idProducto) {
        return ProductoData.getProductos().remove(new Producto(){
            {
                setIdProducto(idProducto);
            }
        });
    }

}
