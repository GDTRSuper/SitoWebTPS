/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.controllers;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import po.ManageDatabase;

/**
 *
 * @author Cristy
 */
@Controller
public class AjaxController {
    ManageDatabase db = new ManageDatabase();
    private Object JSONArray;
    
    @RequestMapping(value="/getEventi")
    public @ResponseBody String eventi(@RequestParam String a){
        return new Gson().toJson(db.cercaEventoAjax(a));
    }
    
}
