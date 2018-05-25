/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.examen.examen.business;

import co.poli.examen.examen.dao.*;
import co.poli.examen.examen.model.Movimiento;
import java.util.ArrayList;

/**
 *
 * @author jeisonvs
 */
public interface IMovimientoBusiness {
    
    Movimiento getMovimiento(String id);
    ArrayList<Movimiento> getMovimientos();
    boolean crearMovimiento(Movimiento movimiento);
    boolean modificarMovimiento(Movimiento movimiento);
    boolean eliminarMovimiento(String idMovimiento);
    Double valorDelInventario(); 
}
