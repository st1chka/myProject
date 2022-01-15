package com.st1ch.andersenWeb.dao;


import com.st1ch.andersenWeb.HibernateSessionFactoryUtil;
import com.st1ch.andersenWeb.models.Roles;
import com.st1ch.andersenWeb.models.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    @Test
    void findById() {
        Set<Roles> roles = new HashSet<>();
        Roles role_admin = new Roles();
        Roles role_manager = new Roles();
        UserDAO userDAO = new UserDAO();
        Users person = new Users();

        role_admin.setName("admin");
        roles.add(role_admin);

        role_manager.setName("manager");
        roles.add(role_manager);

        person.setId(1);
        person.setLogin("Jekson");
        person.setRoles(roles);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(person);
        tr.commit();
        //When
        Users testUsers = userDAO.findById(person.getId());
        //Then
        assertEquals(person.toString(), testUsers.toString());

        session.delete(person);
        session.close();
    }

    @Test
    void save() {

        //Given
        Set<Roles> roles = new HashSet<>();
        Roles role_admin = new Roles();
        Roles role_manager = new Roles();
        Roles role_user = new Roles();

        role_admin.setName("admin");
        roles.add(role_admin);

        role_manager.setName("manager");
        roles.add(role_manager);
        Users person = new Users();
        person.setId(2);
        person.setLogin("Jekson");
        person.setRoles(roles);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();

        //When
        Serializable id = session.save(person);
        tr.commit();


        //Then
        Transaction tr2 = session.beginTransaction();
        assertEquals(person.getLogin(), session.get(Users.class, person.getId()).getLogin());
        assertEquals(person.getRoles(), session.get(Users.class, person.getId()).getRoles());
        assertNotNull(id);
        assertNotNull(session.get(Users.class, id));
        session.delete(person);
        tr2.commit();
        session.close();
    }

    //        @Test
    void update() {
        //Given
        Set<Roles> roles = new HashSet<>();
        Roles role_admin = new Roles();
        Roles role_manager = new Roles();
        Roles role_user = new Roles();

        role_admin.setName("admin");
        roles.add(role_admin);

        role_manager.setName("manager");
        roles.add(role_manager);
        Users person = new Users();
        person.setId(1);
        person.setLogin("Jekson");
        person.setRoles(roles);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tr = session.beginTransaction();


        //When
        Serializable id = session.save(person);
        UserDAO userDAO = new UserDAO();
        userDAO.update(1, "Max");
//        tr.commit();


        //Then

        assertEquals("Max", session.load(Users.class, person.getId()).getLogin());
        assertEquals(person.getRoles(), session.get(Users.class, person.getId()).getRoles());
        assertNotNull(id);
        assertNotNull(session.get(Users.class, id));
        session.delete(person);
        session.close();
    }

    @Test
    void deleteUserById() {
        //Given

        Set<Roles> roles = new HashSet<>();
        Roles role_admin = new Roles();
        Roles role_manager = new Roles();
        UserDAO userDAO = new UserDAO();
        Users person = new Users();

        role_admin.setName("admin");
        roles.add(role_admin);

        role_manager.setName("manager");
        roles.add(role_manager);

        ;
        person.setId(1);
        person.setLogin("Jekson");
        person.setRoles(roles);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();

        //When

        //Then
        assertTrue(userDAO.deleteUserById(person.getId()));

        tr.commit();
        session.close();
    }

    @Test
    void findAll() {
        Set<Roles> roles = new HashSet<>();
        Roles role_admin = new Roles();
        Roles role_manager = new Roles();
        UserDAO userDAO = new UserDAO();
        Users person = new Users();
        Users person2 = new Users();

        role_admin.setName("admin");
        roles.add(role_admin);

        role_manager.setName("manager");
        roles.add(role_manager);

        person.setId(1);
        person.setLogin("Jekson");
        person.setRoles(roles);
        person.setId(2);
        person2.setLogin("Back");
        person2.setRoles(roles);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(person);
        session.save(person2);
        tr.commit();
        //When
        List<Users> testUsers = userDAO.findAll();
        List<Users> testUsers2 = new ArrayList<>();
        testUsers2.add(person);
        testUsers2.add(person2);
        //Then
        assertFalse(testUsers.isEmpty());
        assertEquals(testUsers2.toString(),testUsers.toString());

        session.delete(person);
        session.close();
    }
}