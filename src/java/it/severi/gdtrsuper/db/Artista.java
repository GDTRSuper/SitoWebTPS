/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\trovo2987
 */
@Entity
@Table(name = "Artisti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artisti.findAll", query = "SELECT a FROM Artisti a"),
    @NamedQuery(name = "Artisti.findById", query = "SELECT a FROM Artisti a WHERE a.id = :id"),
    @NamedQuery(name = "Artisti.findByNome", query = "SELECT a FROM Artisti a WHERE a.nome = :nome"),
    @NamedQuery(name = "Artisti.findByCognome", query = "SELECT a FROM Artisti a WHERE a.cognome = :cognome"),
    @NamedQuery(name = "Artisti.findByNomeArte", query = "SELECT a FROM Artisti a WHERE a.nomeArte = :nomeArte")})
public class Artista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Basic(optional = false)
    @Column(name = "nome_arte")
    private String nomeArte;
    @ManyToMany(mappedBy = "artistiCollection")
    private Collection<Evento> eventiCollection;

    public Artista() {
    }

    public Artista(Integer id) {
        this.id = id;
    }

    public Artista(Integer id, String nomeArte) {
        this.id = id;
        this.nomeArte = nomeArte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNomeArte() {
        return nomeArte;
    }

    public void setNomeArte(String nomeArte) {
        this.nomeArte = nomeArte;
    }

    @XmlTransient
    public Collection<Evento> getEventiCollection() {
        return eventiCollection;
    }

    public void setEventiCollection(Collection<Evento> eventiCollection) {
        this.eventiCollection = eventiCollection;
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
        if (!(object instanceof Artista)) {
            return false;
        }
        Artista other = (Artista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.severi.gdtrsuper.db.Artisti[ id=" + id + " ]";
    }
    
}
