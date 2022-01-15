package com.st1ch.andersenWeb.service;

import com.st1ch.andersenWeb.dao.UserDAO;
import com.st1ch.andersenWeb.models.Users;

import java.io.Serializable;
import java.util.List;

public class UserService {

    private UserDAO usersDao = new UserDAO();

    public UserService() {
    }

    public Users findUser(Long id) {
        return usersDao.findById(id);
    }

    public void saveUser(Users user) {
        usersDao.save(user);
    }

    public void deleteUser(Serializable id) {
        usersDao.deleteUserById(id);
    }

    public void updateUser(Serializable id, String name) {
        usersDao.update(id, name);
    }

    public List<Users> findAllUsers() {
        return usersDao.findAll();
    }

}