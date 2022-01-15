package com.st1ch.andersenWeb.dao;

import com.st1ch.andersenWeb.HibernateSessionFactoryUtil;
import com.st1ch.andersenWeb.models.Roles;
import com.st1ch.andersenWeb.models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class RoleDAO {
    private final SessionFactory sessionFactory;

    public RoleDAO() {
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    public Roles findById(int id) {
        Session session = sessionFactory.openSession();
        Roles roles = session.get(Roles.class, id);
        session.close();
        return roles;
    }

    public void save(Roles roles) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(roles);
        tx1.commit();
        session.close();
    }

    public void update(Serializable id, String name) {
        Session session = sessionFactory.openSession();
        Roles roles = session.get(Roles.class, id);
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            roles.setName(name);
            session.update(roles);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    public boolean deleteRoleById(Serializable id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Roles roles = session.get(Roles.class, id);
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.delete(roles);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return roles != null;
    }

    public Users findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    public List<Roles> findAll() {
        List<Roles> roles = (List<Roles>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From Roles").list();
        return roles;
    }
}
