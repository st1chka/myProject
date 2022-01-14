package com.st1ch.andersenWeb.dao;

import com.st1ch.andersenWeb.HibernateSessionFactoryUtil;
import com.st1ch.andersenWeb.models.Roles;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDAO  {
    public Roles findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Roles.class, id);
    }

    public void save(Roles roles) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(roles);
        tx1.commit();
        session.close();
    }

    public void update(Roles roles) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(roles);
        tx1.commit();
        session.close();
    }

    public void delete(Roles roles) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(roles);
        tx1.commit();
        session.close();
    }

    public Roles findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Roles.class, id);
    }

    public List<Roles> findAll() {
        List<Roles> roles = (List<Roles>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From Roles").list();
        return roles;
    }
}
