package com.st1ch.andersenWeb.dao;

import com.st1ch.andersenWeb.HibernateSessionFactoryUtil;
import com.st1ch.andersenWeb.models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class UserDAO {
    private final SessionFactory sessionFactory;

    public UserDAO() {
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    }

    public Users findById(Serializable id) {
        Session session = sessionFactory.openSession();
        Users users = session.get(Users.class, id);
        session.close();
        return users;
    }

    public void save(Users user) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Serializable id, String setName) {
        Session session = sessionFactory.openSession();
        Users users = session.get(Users.class, id);
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            users.setLogin(setName);
            session.update(users);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    public boolean deleteUserById(Serializable id)  {
        Session session = sessionFactory.openSession();
        Users users = session.get(Users.class, id);
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.delete(users);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users != null;
    }

    public List<Users> findAll() {
        List<Users> users = (List<Users>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From Users").list();
        return users;
    }
}