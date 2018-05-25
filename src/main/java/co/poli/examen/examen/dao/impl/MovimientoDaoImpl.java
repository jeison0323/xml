/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.examen.examen.dao.impl;

import co.poli.examen.examen.dao.IMovimientoDao;
import co.poli.examen.examen.data.MovimientoData;
import co.poli.examen.examen.model.Movimiento;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jeisonvs
 */
@Repository
public class MovimientoDaoImpl implements IMovimientoDao {

    @Override
    public Movimiento getMovimiento(String id) {
        Movimiento movimiento = null;

        for (Movimiento product : MovimientoData.getMovimientos()) {
            if (product.getIdMovimiento().equals(id)) {
                movimiento = product;
                break;
            }
        }
        return movimiento;
    }

    @Override
    public ArrayList<Movimiento> getMovimientos() {
        return MovimientoData.getMovimientos();
    }

    @Override
    public boolean crearMovimiento(Movimiento movimiento) {
        return MovimientoData.getMovimientos().add(movimiento);
    }

    @Override
    public boolean modificarMovimiento(Movimiento movimiento) {
        List<Movimiento> movimientos = MovimientoData.getMovimientos();
        int indexMovimiento = movimientos.lastIndexOf(movimiento);
        boolean exist = indexMovimiento != -1;
        if (exist) {
            movimientos.set(indexMovimiento, movimiento);
        }
        return exist;
    }

    @Override
    public boolean eliminarMovimiento(String idMovimiento) {
        return MovimientoData.getMovimientos().remove(new Movimiento(){
            {
                setIdMovimiento(idMovimiento);
            }
        });
    }

}
