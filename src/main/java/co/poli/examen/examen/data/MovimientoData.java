/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.examen.examen.data;

import co.poli.examen.examen.model.Movimiento;
import java.util.ArrayList;

/**
 *
 * @author jeisonvs
 */
public class MovimientoData {
    private static ArrayList<Movimiento> movimientos;
    
    static {
        movimientos = new ArrayList<Movimiento>(){
            {
                add(new Movimiento("mv1", ProductoData.getProductos().get(1), Movimiento.TIPO_ENTRADA, 400d, 3000d));
                add(new Movimiento("mv2", ProductoData.getProductos().get(2), Movimiento.TIPO_SALIDA, 300d, 5000d));
                add(new Movimiento("mv3", ProductoData.getProductos().get(3), Movimiento.TIPO_ENTRADA, 100d, 8000d));
            }
        };
    }

    public static ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }
    
}
