/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FSEVERI\trovo2987
 */
@Entity
@Table(name = "Commenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commenti.findAll", query = "SELECT c FROM Commenti c"),
    @NamedQuery(name = "Commenti.findById", query = "SELECT c FROM Commenti c WHERE c.id = :id"),
    @NamedQuery(name = "Commenti.findByVoto", query = "SELECT c FROM Commenti c WHERE c.voto = :voto"),
    @NamedQuery(name = "Commenti.findByTesto", query = "SELECT c FROM Commenti c WHERE c.testo = :testo")})
public class Commento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "voto")
    private Short voto;
    @Column(name = "testo")
    private String testo;
    @JoinColumn(name = "evento", referencedColumnName = "id")
    @ManyToOne
    private Evento evento;
    @JoinColumn(name = "utente", referencedColumnName = "nickname")
    @ManyToOne
    private Utente utente;

    public Commento() {
    }

    public Commento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getVoto() {
        return voto;
    }

    public void setVoto(Short voto) {
        this.voto = voto;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commento)) {
            return false;
        }
        Commento other = (Commento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.severi.gdtrsuper.db.Commenti[ id=" + id + " ]";
    }
    
}
