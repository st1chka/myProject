package com.st1ch.andersenWeb.dao;

import com.st1ch.andersenWeb.HibernateSessionFactoryUtil;
import com.st1ch.andersenWeb.models.Roles;
import com.st1ch.andersenWeb.models.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {
    public Users findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    public void save(Users user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Users user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Users user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Roles findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Roles.class, id);
    }

    public List<Users> findAll() {
        List<Users> users = (List<Users>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From Users").list();
        return users;
    }
}