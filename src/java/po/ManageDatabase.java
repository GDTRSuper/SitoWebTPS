package po;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import it.severi.gdtrsuper.db.Artista;
import it.severi.gdtrsuper.db.Categoria;
import it.severi.gdtrsuper.db.Commento;
import it.severi.gdtrsuper.db.Evento;
import java.util.ArrayList;
import java.util.Collection;
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

    public int getMediaVotoPerEvento(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Query q = session.createSQLQuery("SELECT * FROM Eventi where id = ?").addEntity(Evento.class);
        q.setInteger(0, id);
        if (q.list().size() >0){
            Evento e =(Evento)q.list().get(0);
            Collection<Commento> commenti = e.getCommentiCollection();
            int total=0;
            for (Commento c : commenti){
                total +=c.getVoto();
            }
            return total/commenti.size();
        }
         
        return 0;
        
    }

    public Evento getEventoById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        try { 
           tx = session.beginTransaction();
           Query q = session.createSQLQuery("SELECT * FROM Eventi where id= ? ").addEntity(Evento.class);
           q.setInteger(0, id);
           if (q.list().size()>0) return (Evento)q.list().get(0);
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    public Artista getArtistaByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Artista where id = :id");
            query.setInteger("id", id);

            List persone = query.list();
            if (persone.size() > 0) {
                return (Artista) persone.get(0);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    public void deleteArtista(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(this.getArtistaByID(id));

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public List<Artista> getArtistaByNome(String nome) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Artista where nome LIKE '% :nome %'");
            query.setString(":nome", nome);

            List persone = query.list();
            List<Artista> ret = new ArrayList<Artista>();
            for (Object a : persone) {
                ret.add((Artista) a);
            }
            tx.commit();
            return ret;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    public List<Artista> getArtisti() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Artista");

            List persone = query.list();
            List<Artista> ret = new ArrayList<Artista>();
            for (Object a : persone) {
                ret.add((Artista) a);
            }
            tx.commit();
            return ret;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    public List<Categoria> getCategorie() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Categoria");

            List cats = query.list();
            List<Categoria> ret = new ArrayList<Categoria>();
            for (Object a : cats) {
                ret.add((Categoria) a);
            }
            tx.commit();
            return ret;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

}
