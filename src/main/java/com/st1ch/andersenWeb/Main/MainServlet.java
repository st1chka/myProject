package com.st1ch.andersenWeb.Main;

import com.st1ch.andersenWeb.HibernateSessionFactoryUtil;
import com.st1ch.andersenWeb.dao.UserDAO;
import com.st1ch.andersenWeb.models.Roles;
import com.st1ch.andersenWeb.models.Users;
import com.st1ch.andersenWeb.service.UserService;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MainServlet {
    @SneakyThrows
    public static void main(String[] args) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

//
//        //Add role
//        Set<Roles> roles = new HashSet<>();
//        Roles role_admin = new Roles();
//        Roles role_manager = new Roles();
//        Roles role_user = new Roles();
//
//        role_admin.setName("admin");
//        roles.add(role_admin);
//
//        role_manager.setName("manager");
//        roles.add(role_manager);
//
//        role_user.setName("user");
//        roles.add(role_user);
//
//
//
//
//
//        //Add user
//        Users evgen = new Users();
//        evgen.setLogin("Evgen");
//
//        Users jango = new Users();
//        jango.setLogin("Jango");
//
//
//        Set<Users> users = new HashSet<>();
//        users.add(evgen);
//        users.add(jango);
//
//        evgen.setRoles(roles);
//        session.save(evgen);
//        session.save(jango);
//        System.out.println(evgen);
//        System.out.println(jango);
//
//        UserDAO userService = new UserDAO();
//        userService.update(1,"lll");


        Set<Roles> roles = new HashSet<>();
        Roles role_admin = new Roles();
        Roles role_manager = new Roles();
        Roles role_user = new Roles();

        role_admin.setName("admin");
        roles.add(role_admin);

        role_manager.setName("manager");
        roles.add(role_manager);
        Users person = new Users();
//        person.setId(1);
        person.setLogin("Jekson");
        person.setRoles(roles);
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tr = session.beginTransaction();



        //When
        Serializable id = session.save(person);
        UserDAO userDAO = new UserDAO();
        userDAO.update(1, "Max");
//        tr.commit();


        session.getTransaction().commit();


    }
}
