/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.examen.examen.controller;

import co.poli.examen.examen.business.IProductoBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jeisonvs
 */
@RestController
@RequestMapping(value = "producto")
public class ProductoController {
    
    @Autowired
    IProductoBusiness productoBusiness;
    
}
