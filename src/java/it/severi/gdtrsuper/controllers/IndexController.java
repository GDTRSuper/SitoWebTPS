/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.controllers;  
import po.ManageDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Cristy
 */
@Controller
public class IndexController {
    ManageDatabase db = new ManageDatabase();
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String index(ModelMap map){
        map.put("cats", db.getCategorie());
        map.put("ultimiEventi",db.getEventi() );
        return "index";
    }
    
    @RequestMapping(value="/categoria",method=RequestMethod.GET)
    public String cats(ModelMap map, @RequestParam(value="id") Integer id){
       map.put("ultimiEventi", db.getCategoriaByID(id).getEventiCollection());
       map.put("cat", db.getCategoriaByID(id));
        return "categoria";
    }
  
  
}
