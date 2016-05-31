/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.controllers;

import it.severi.gdtrsuper.db.Artista;
import it.severi.gdtrsuper.db.Commento;
import it.severi.gdtrsuper.db.Evento;
import it.severi.gdtrsuper.db.Utente;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import po.ManageDatabase;


@Controller
@SessionAttributes({"utente"})
public class EventoController {
  ManageDatabase db = new ManageDatabase();
    
    @RequestMapping(value="/evento",method=RequestMethod.GET)
    public String index(ModelMap map, @RequestParam(value="id", required=false)int id,@ModelAttribute Evento ev){
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
        com.setUtente(db.getUtenteByNick("bruno"));
        db.salvaCommento(com);
        // db.aggiornaEvento(evento);
        map.put("evento",evento);
        return "aggiungiCommento";
    }
    @RequestMapping(value="/createEvento",method=RequestMethod.GET)
    public String aggiugniEvento(ModelMap map){
        map.put("categorie", db.getCategorie());
        map.put("artisti",db.getArtisti());
        return "nuovoEvento";
    }
    @RequestMapping(value="/aggiungiEvento",method=RequestMethod.GET)
    public String aggiugniEvento(ModelMap map,@ModelAttribute("utente") Utente user, @RequestParam(value="titolo", required=true) String titolo, @RequestParam(value="data", required=true) Date data, @RequestParam(value="luogo", required=true) String luogo, @RequestParam(value="descrizione", required=true)String descr, @RequestParam(value="immagine", required=true)String img, @RequestParam(value="categoria", required=true)int cat,@RequestParam(value="artisti", required=false)ArrayList<Integer> artisti){
        Evento evento = new Evento();
        evento.setCategoria(db.getCategoriaByID(cat));
        evento.setTitolo(titolo);
        evento.setData(data);
        evento.setLuogo(luogo);
        evento.setCreatore(db.getUtenteByNick(user.getNickname()));
        evento.setDescrizione(descr);
        evento.setImmagine(img);
        Collection<Artista> arts = new ArrayList<>();
        if(artisti!=null){
            for(Integer a: artisti){
                arts.add(db.getArtistaByID(a));
            }
        }
        evento.setArtistiCollection(arts);
        int id = db.salvaEvento(evento);
        System.out.println("evento: "+evento+" id="+id);
        return "redirect:/evento?id="+id;
    }
}
