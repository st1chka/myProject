package com.st1ch.andersenWeb.Main;

import com.st1ch.andersenWeb.dao.RoleDAO;
import com.st1ch.andersenWeb.dao.UserDAO;
import com.st1ch.andersenWeb.models.Roles;
import com.st1ch.andersenWeb.models.Users;
import com.st1ch.andersenWeb.service.UserService;
import lombok.SneakyThrows;

import javax.management.relation.Role;
import java.util.*;
import java.util.stream.Collectors;

public class MainServlet {
    @SneakyThrows
    public static void main(String[] args) {

        UserService userService = new UserService();
        RoleDAO userDAO = new RoleDAO();
        Roles roles = new Roles("Masha");
        userDAO.save(roles);


    }
}
