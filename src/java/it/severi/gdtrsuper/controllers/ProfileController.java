/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.controllers;

import it.severi.gdtrsuper.db.Utente;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String cats(ModelMap map,HttpServletRequest request){
        u = (Utente)request.getSession().getAttribute("utente");
        map.put("utente",u);
        map.put("categorie",u.getCategorieCollection());
        return "profile";
    }

    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    public @ResponseBody
    String checklogin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request) {

        Utente u = db.getUtenteByNick(username);
        if (u == null) {
            return "false";
        }
        if (u.getNickname().equals(username) && u.getPassword().equals(password)) {
            request.getSession().setAttribute("utente", u);
            return "true";
        } else {
            return "false";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap map, HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";

    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String mods(ModelMap map) {
        map.put("utente", u);
        return "ModificaInformazioni";
    }

    @RequestMapping(value = "/controllaPassword", method = RequestMethod.POST)
    public String psw(ModelMap map, @RequestParam(value = "oldPsw") String oldPsw, @RequestParam(value = "newPsw") String newPsw, @RequestParam(value = "repeatPsw") String repeatPsw) {
        if (!u.getPassword().equals(oldPsw)) {
            map.put("risposta", "password errata");
        } else {
            if (!newPsw.equals(repeatPsw)) {
                map.put("risposta", "password diverse");
            } else {
                u.setPassword(newPsw);
                db.salvaUtente(u);
                map.put("risposta", "password aggiornata con successo");
            }

        }
        return "ModificaInformazioni";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerP(ModelMap map) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerP(ModelMap map, @RequestParam(value = "username") String nickname,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "nome") String nome,
            @RequestParam(value = "cognome") String cognome, HttpServletRequest request) {
        if (!nickname.isEmpty() && !password.isEmpty() && !nome.isEmpty() && !cognome.isEmpty() ) {

            List<Utente> utenti = db.getUtenti();

            for (Utente v : utenti) {
                if (v.getNickname().equals(nickname)) {
                    return "redirect:/register?exists=true";
                }

            }
            Utente newUtente = new Utente();
            newUtente.setNome(nome);
            newUtente.setCognome(cognome);
            newUtente.setPassword(password);
            newUtente.setNickname(nickname);
            db.salvaUtente(newUtente);
            request.getSession().setAttribute("utente", newUtente);

            return "redirect:/";
        } else {
            return "redirect:/register?fields=true";
        }

    }
    
    @RequestMapping(value="/modificaNCE",method=RequestMethod.GET)
    public String boh(ModelMap map, @RequestParam(value="email") String email, @RequestParam(value="nome") String nome, @RequestParam(value="cognome") String cognome){
        //System.out.println("nome: "+nome);
        if(!email.isEmpty()) u.setEmail(email);
        if(!nome.isEmpty()) u.setNome(nome);
        if(!cognome.isEmpty()) u.setCognome(cognome);
        db.salvaUtente(u);
        return "redirect:/user?nick=bruno";
    }
    
}
