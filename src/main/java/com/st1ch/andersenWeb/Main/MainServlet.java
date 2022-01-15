package com.st1ch.andersenWeb.Main;

import com.st1ch.andersenWeb.HibernateSessionFactoryUtil;
import com.st1ch.andersenWeb.dao.RoleDAO;
import com.st1ch.andersenWeb.dao.UserDAO;
import com.st1ch.andersenWeb.models.Roles;
import com.st1ch.andersenWeb.models.Users;
import com.st1ch.andersenWeb.service.UserService;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainServlet {
    @SneakyThrows
    public static void main(String[] args) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();


        Roles role_admin = new Roles();

        role_admin.setName("Admin");

        session.save(role_admin);

        //When
        RoleDAO role_adminDAO = new RoleDAO();

        role_adminDAO.save(role_admin);


        List<Roles> listRoles = new ArrayList<>();
        listRoles.add(role_admin);


        RoleDAO roleDAO = new RoleDAO();
        roleDAO.update(1L, "Manager");

    }
}
