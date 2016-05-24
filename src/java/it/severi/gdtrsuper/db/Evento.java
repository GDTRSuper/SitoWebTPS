/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\trovo2987
 */
@Entity
@Table(name = "Eventi")
@XmlRootElement
 public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "titolo")
    private String titolo;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "luogo")
    private String luogo;
    @Column(name = "descrizione")
    private String descrizione;

    public String getDescrizione() {
        return descrizione;
    }

    public void aggiungiCommento(Commento c){
        commentiCollection.add(c);
    }
    
    public String getImmagine() {
        return immagine;
    }
    @Column(name = "Immagine")
    private String immagine;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Eventi_Artisti", joinColumns = {
        @JoinColumn(name = "evento", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "artista", referencedColumnName = "id")})
    
    private Collection<Artista> artistiCollection;
    @JoinColumn(name = "creatore", referencedColumnName = "nickname")
    @ManyToOne(optional = false)
    private Utente creatore;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evento")
    private Collection<Commento> commentiCollection;
        
    public int getNumCommenti(){
        return commentiCollection.size();
    }
    
    public Evento() {
    }

    public Evento(Integer id) {
        this.id = id;
    }
    
    public float getMedia(){
        int total=0;
        for (Commento c : commentiCollection){
            total += c.getVoto();
        }
        if (commentiCollection.size()==0) return 0;
        return total/commentiCollection.size();
    }

    public Evento(Integer id, String titolo, Date data, String luogo) {
        this.id = id;
        this.titolo = titolo;
        this.data = data;
        this.luogo = luogo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    @XmlTransient
    public Collection<Artista> getArtistiCollection() {
        return artistiCollection;
    }

    public void setArtistiCollection(Collection<Artista> artistiCollection) {
        this.artistiCollection = artistiCollection;
    }

    public Utente getCreatore() {
        return creatore;
    }

    public void setCreatore(Utente creatore) {
        this.creatore = creatore;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @XmlTransient
    public Collection<Commento> getCommentiCollection() {
        return commentiCollection;
    }

    public void setCommentiCollection(Collection<Commento> commentiCollection) {
        this.commentiCollection = commentiCollection;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", titolo=" + titolo + ", data=" + data + ", luogo=" + luogo + ", descrizione=" + descrizione + ", immagine=" + immagine + ", artistiCollection=" + artistiCollection + ", creatore=" + creatore + ", categoria=" + categoria + ", commentiCollection=" + commentiCollection + '}';
    }

    
    
}
