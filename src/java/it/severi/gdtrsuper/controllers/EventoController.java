/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.controllers;

import it.severi.gdtrsuper.db.Commento;
import it.severi.gdtrsuper.db.Evento;
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
    
    @RequestMapping(value="/aggiungiCommento",method=RequestMethod.POST)
    public String aggiugniEvento(ModelMap map, @RequestParam(value="nuovoCommento", required=true)String commento, @RequestParam(value="rating", required=true)short rating, @RequestParam(value="evento", required=true)int id){
        Evento evento = db.getEventoById(id);
        Commento com = new Commento();
        if(commento.isEmpty()) return "errorPage";
        else com.setTesto(commento);
        com.setVoto(rating);
        com.setEvento(evento);
        com.setUtente(null);
        db.salvaCommento(com);
        map.put("evento",evento);
        return "aggiungiCommento";
    }
}
