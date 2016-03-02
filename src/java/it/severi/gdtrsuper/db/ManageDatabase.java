package it.severi.gdtrsuper.db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import it.severi.gdtrsuper.config.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction; 

/**
 *
 * @author FSEVERI\trovo2987
 */
public class ManageDatabase {
    
    public List<Artista> getArtisti(){
        Session session = HibernateUtil.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("Artisti.findAll");
                
            List persone = query.list();
            List<Artista> ret = new ArrayList<Artista>();
            for (Object a : persone){
                ret.add((Artista)a);
            }
            tx.commit();
            return ret;
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        
            return null;
    }
    
    public Artista getArtista(int id){
        Session session = HibernateUtil.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("Artisti.findById").setInteger("id", id);
                
            return (Artista)query.list().get(0);
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        
            return null;
    }
     
}
