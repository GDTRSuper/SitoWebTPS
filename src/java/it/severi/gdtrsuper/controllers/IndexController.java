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

/**
 *
 * @author Cristy
 */
@Controller
public class IndexController {
    ManageDatabase db = new ManageDatabase();
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String index(ModelMap map){
        map.put("artisti", db.getArtisti());
        return "index";
    }
    
}
