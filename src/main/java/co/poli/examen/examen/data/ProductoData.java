/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.examen.examen.data;

import co.poli.examen.examen.model.Producto;
import java.util.ArrayList;

/**
 *
 * @author jeisonvs
 */
public class ProductoData {

    private static ArrayList<Producto> productos;

    static {
        productos = new ArrayList<Producto>() {
            {
                add(new Producto("pr1", "producto1", 2500d, 3000d));
                add(new Producto("pr2", "producto2", 3500d, 4000d));
                add(new Producto("pr3", "producto3", 4500d, 5000d));
            }
        };
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }
    
}
