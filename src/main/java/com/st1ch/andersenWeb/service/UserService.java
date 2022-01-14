package com.st1ch.andersenWeb.service;

import com.st1ch.andersenWeb.dao.UserDAO;
import com.st1ch.andersenWeb.models.Roles;
import com.st1ch.andersenWeb.models.Users;

import java.util.List;

public class UserService {

    private UserDAO usersDao = new UserDAO();

    public UserService() {
    }

    public Users findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(Users user) {
        usersDao.save(user);
    }

    public void deleteUser(Users user) {
        usersDao.delete(user);
    }

    public void updateUser(Users user) {
        usersDao.update(user);
    }

    public List<Users> findAllUsers() {
        return usersDao.findAll();
    }

    public Roles findAutoById(int id) {
        return usersDao.findAutoById(id);
    }

}