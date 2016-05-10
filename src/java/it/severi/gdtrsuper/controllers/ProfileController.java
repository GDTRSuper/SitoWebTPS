/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.controllers;

import it.severi.gdtrsuper.db.Utente;
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
    Utente u;
    
    @RequestMapping(value="/user",method=RequestMethod.GET)
    public String cats(ModelMap map, @RequestParam(value="nick") String nick){
        u = db.getUtenteByNick(nick);
        map.put("utente",u);
        map.put("categorie",u.getCategorieCollection());
        return "profile";
    }
         
    @RequestMapping(value="/modify",method=RequestMethod.GET)
    public String mods(ModelMap map){
        map.put("utente",u);
        return "ModificaInformazioni";
    }
    
    @RequestMapping(value="/controllaPassword",method=RequestMethod.POST)
    public String psw(ModelMap map, @RequestParam(value="oldPsw") String oldPsw, @RequestParam(value="newPsw") String newPsw, @RequestParam(value="repeatPsw") String repeatPsw){
        if(!u.getPassword().equals(oldPsw)){
            map.put("risposta","password errata");
        }else{
            if(!newPsw.equals(repeatPsw)){
                map.put("risposta","password diverse");
            }else{
                u.setPassword(newPsw);
                db.salvaUtente(u);
                map.put("risposta","password aggiornata con successo");
            }
            
        }
        return"ModificaInformazioni";
    }
}
