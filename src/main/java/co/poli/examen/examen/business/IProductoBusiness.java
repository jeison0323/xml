/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.examen.examen.business;

import co.poli.examen.examen.dao.*;
import co.poli.examen.examen.model.Producto;
import java.util.ArrayList;

/**
 *
 * @author jeisonvs
 */
public interface IProductoBusiness {
    
    Producto getProducto(String id);
    ArrayList<Producto> getProductos();
    boolean crearProducto(Producto producto);
    boolean modificarProducto(Producto producto);
    boolean eliminarProducto(String idProducto);
}
