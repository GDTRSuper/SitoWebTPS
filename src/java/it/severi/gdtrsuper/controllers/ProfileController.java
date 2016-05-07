/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.controllers;

import it.severi.gdtrsuper.db.Utente;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import po.ManageDatabase;

/**
 *
 * @author FSEVERI\depaula2995
 */
@Controller
public class ProfileController {
    ManageDatabase db = new ManageDatabase();
    
    @RequestMapping(value="/user",method=RequestMethod.GET)
    public String cats(ModelMap map, @RequestParam(value="nick") String nick){
        Utente u = db.getUtenteByNick(nick);
        map.put("utente",u);
        map.put("categorie",u.getCategorieCollection());
        return "profile";
    }
    
    
    @RequestMapping(value="/checklogin",method=RequestMethod.POST)
    public String checklogin(ModelMap map, @RequestParam(value="username") String username,@RequestParam(value="password") String password,HttpServletRequest request){
        
        
        Utente u = db.getUtenteByNick(username);
        
        map.put("utente",u);
        map.put("categorie",u.getCategorieCollection());
        return "profile";
    }
  
  
}
