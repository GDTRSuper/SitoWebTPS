/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.severi.gdtrsuper.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\trovo2987
 */
@Entity
@Table(name = "Utenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utenti.findAll", query = "SELECT u FROM Utenti u"),
    @NamedQuery(name = "Utenti.findByNickname", query = "SELECT u FROM Utenti u WHERE u.nickname = :nickname"),
    @NamedQuery(name = "Utenti.findByNome", query = "SELECT u FROM Utenti u WHERE u.nome = :nome"),
    @NamedQuery(name = "Utenti.findByCognome", query = "SELECT u FROM Utenti u WHERE u.cognome = :cognome"),
    @NamedQuery(name = "Utenti.findByEmail", query = "SELECT u FROM Utenti u WHERE u.email = :email"),
    @NamedQuery(name = "Utenti.findByPassword", query = "SELECT u FROM Utenti u WHERE u.password = :password")})
public class Utente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nickname")
    private String nickname;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JoinTable(name = "Utenti_Categorie", joinColumns = {
        @JoinColumn(name = "utente", referencedColumnName = "nickname")}, inverseJoinColumns = {
        @JoinColumn(name = "categoria", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Categoria> categorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatore")
    private Collection<Evento> eventiCollection;
    @OneToMany(mappedBy = "utente")
    private Collection<Commento> commentiCollection;

    public Utente() {
    }

    public Utente(String nickname) {
        this.nickname = nickname;
    }

    public Utente(String nickname, String nome, String cognome, String password) {
        this.nickname = nickname;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Categoria> getCategorieCollection() {
        return categorieCollection;
    }

    public void setCategorieCollection(Collection<Categoria> categorieCollection) {
        this.categorieCollection = categorieCollection;
    }

    @XmlTransient
    public Collection<Evento> getEventiCollection() {
        return eventiCollection;
    }

    public void setEventiCollection(Collection<Evento> eventiCollection) {
        this.eventiCollection = eventiCollection;
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
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.nickname == null && other.nickname != null) || (this.nickname != null && !this.nickname.equals(other.nickname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.severi.gdtrsuper.db.Utenti[ nickname=" + nickname + " ]";
    }
    
}
