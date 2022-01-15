package com.st1ch.andersenWeb.Main;

import com.st1ch.andersenWeb.HibernateSessionFactoryUtil;
import com.st1ch.andersenWeb.models.Roles;
import com.st1ch.andersenWeb.models.Users;
import lombok.SneakyThrows;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class MainServlet {
    @SneakyThrows
    public static void main(String[] args) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();


        //Add role
        Set<Roles> roles = new HashSet<>();
        Set<Roles> roles2 = new HashSet<>();
        Roles admin = new Roles();
        Roles admin1 = new Roles();
        Roles manager = new Roles();

        admin.setName("admin");
        roles.add(admin);

        admin.setName("admin");
        roles2.add(admin);

        admin1.setName("admin");
        roles.add(admin1);

        manager.setName("manager");
        roles.add(manager);





        //Add user
        Users evgen = new Users();
        evgen.setLogin("Evgen");

        Users jango = new Users();
        jango.setLogin("Jango");
        jango.setRoles(roles2);

        Set<Users> users = new HashSet<>();
        users.add(evgen);
        users.add(jango);

        evgen.setRoles(roles);
        session.save(evgen);
        session.save(jango);
        System.out.println(evgen);
        System.out.println(jango);


        session.getTransaction().commit();


    }
}
