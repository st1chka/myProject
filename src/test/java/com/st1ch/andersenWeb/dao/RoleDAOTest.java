package com.st1ch.andersenWeb.dao;

import com.st1ch.andersenWeb.HibernateSessionFactoryUtil;
import com.st1ch.andersenWeb.models.Roles;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoleDAOTest {

    @Test
    void findById() {
        //Given
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        RoleDAO roleDAO = new RoleDAO();
        Roles role_admin = new Roles();
        Roles role_manager = new Roles();

        role_admin.setName("Admin");
        role_manager.setName("Manager");


        //When
        List<Roles> listRoles = new ArrayList<>();
        listRoles.add(role_admin);
        listRoles.add(role_manager);

        roleDAO.save(role_admin);
        roleDAO.save(role_manager);

        List<Roles> listRoleDB = roleDAO.findAll();

        //Then

        assertEquals(listRoles.get(1), listRoleDB.get(1));

        roleDAO.deleteRoleById(role_admin.getId());
        roleDAO.deleteRoleById(role_manager.getId());
        session.close();
    }

    @Test
    void save() {
        //Given
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        Roles role_admin = new Roles();
        Roles role_manager = new Roles();
        RoleDAO roleDAO = new RoleDAO();


        role_admin.setName("Admin");
        role_manager.setName("Manager");


        //When
        List<Roles> rolesList = new ArrayList<>();
        rolesList.add(role_admin);
        rolesList.add(role_manager);

        roleDAO.save(role_admin);
        roleDAO.save(role_manager);

        List<Roles> roleDAOlist = roleDAO.findAll();

        //Then

        assertEquals(rolesList.toString(), roleDAOlist.toString());

        roleDAO.deleteRoleById(role_admin.getId());
        roleDAO.deleteRoleById(role_manager.getId());
        session.close();
    }

    @Test
    void update() {
        //Given
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        RoleDAO roleDAO = new RoleDAO();

        Roles role_admin = new Roles();
        role_admin.setName("Manager");
        roleDAO.save(role_admin);

        Transaction tr2 = session.beginTransaction();

        //When
        roleDAO.update(1L, "Admin");

        //Then
        assertEquals("Admin", session.get(Roles.class, role_admin.getId()).getName());

        roleDAO.deleteRoleById(role_admin.getId());
        tr2.commit();
        session.close();

    }

    @Test
    void deleteRoleById() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        RoleDAO roleDAO = new RoleDAO();
        Roles role_admin = new Roles();

        role_admin.setName("Admin");

        //When
        List<Roles> listRoles = new ArrayList<>();

        listRoles.add(role_admin);
        roleDAO.save(role_admin);

        boolean test = roleDAO.deleteRoleById(role_admin.getId());

        //Then
        List<Roles> listRoleDB = roleDAO.findAll();
        assertTrue(test);
        assertTrue(listRoleDB.isEmpty());

        roleDAO.deleteRoleById(role_admin.getId());

        session.close();
    }


    @Test
    void findAllList() {
        //Given
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        RoleDAO roleDAO = new RoleDAO();
        Roles role_admin = new Roles();
        Roles role_manager = new Roles();

        role_admin.setName("Admin");
        role_manager.setName("Manager");


        //When
        List<Roles> listRoles = new ArrayList<>();
        listRoles.add(role_admin);
        listRoles.add(role_manager);

        roleDAO.save(role_admin);
        roleDAO.save(role_manager);

        List<Roles> listRoleDB = roleDAO.findAll();

        //Then

        assertEquals(listRoles, listRoleDB);

        roleDAO.deleteRoleById(role_admin.getId());
        roleDAO.deleteRoleById(role_manager.getId());
        session.close();
    }

}