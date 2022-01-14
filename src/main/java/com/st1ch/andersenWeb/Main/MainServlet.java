package com.st1ch.andersenWeb.Main;

import com.st1ch.andersenWeb.dao.RoleDAO;
import com.st1ch.andersenWeb.dao.UserDAO;
import com.st1ch.andersenWeb.models.Roles;
import com.st1ch.andersenWeb.models.Users;
import lombok.SneakyThrows;

import javax.management.relation.Role;
import java.util.*;
import java.util.stream.Collectors;

public class MainServlet {
    @SneakyThrows
    public static void main(String[] args) {

        UserDAO usersDao = new UserDAO();
        System.out.println(usersDao.find(3L));
        System.out.println(usersDao.findAll());


        RoleDAO roleDao = new RoleDAO();
        System.out.println(roleDao.find(3L));
        System.out.println(roleDao.findAll());
    }
}
