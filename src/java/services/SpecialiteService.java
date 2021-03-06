/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import classes.Specialite;
import dao.IDao;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author salah
 */
public class SpecialiteService implements IDao<Specialite>{

    @Override
    public void create(Specialite o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Specialite> findAll(){
        List<Specialite> spe = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        spe = session.createQuery("From Specialite").list();
        session.getTransaction().commit();
        session.close();
        return spe;
    }

    @Override
    public void delete(Specialite o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Specialite findById(int id) {
        Specialite s = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        s = (Specialite) session.get(Specialite.class, id);
        session.getTransaction().commit();
        session.close();
        return s;
    }

    @Override
    public void update(Specialite o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }
}
