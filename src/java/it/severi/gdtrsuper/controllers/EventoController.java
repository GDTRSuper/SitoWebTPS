/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import po.ManageDatabase;

/**
 *
 * @author Giacomo
 */
@Controller
public class EventoController {
  ManageDatabase db = new ManageDatabase();
    
    @RequestMapping(value="/evento",method=RequestMethod.GET)
    public String index(ModelMap map, @RequestParam(value="id", required=true)int id){
        map.put("evento", db.getEventoById(id));
        return "evento";
    }
}
