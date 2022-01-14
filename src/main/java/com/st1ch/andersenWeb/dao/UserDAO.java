package com.st1ch.andersenWeb.dao;

import com.st1ch.andersenWeb.config.DataBase;
import com.st1ch.andersenWeb.models.Roles;
import com.st1ch.andersenWeb.models.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO implements DAO<Users, Long> {

    RoleDAO role = new RoleDAO();

    public UserDAO() {

    }

    public static class SingletonHelper {
        private static final UserDAO INSTANCE = new UserDAO();
    }

    public static UserDAO getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<Users> find(Long id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id=?";
        String login = "";
        ;

        Connection conn = DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            login = resultSet.getString("login");
        }

        return Optional.of(new Users(login));

    }

    @Override
    public List<Users> findAll() throws SQLException {
        List<Users> listUsers = new ArrayList<>();
        Roles roles = new Roles();


        String sql = "SELECT * FROM users";

        Connection conn = DataBase.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String login = resultSet.getString("login");
            Users users = new Users(login);

            listUsers.add(users);
        }
        return listUsers;
    }

    @Override
    public boolean save(Users users) throws SQLException {
        String sql = "INSERT into users (login) VALUES (?)";
        boolean rowInserted = false;
        Connection connection = DataBase.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, users.getLogin());

        rowInserted = statement.executeUpdate() > 0;
        return rowInserted;
    }

    @Override
    public boolean update(Users users) throws SQLException {
        String sql = "UPDATE  users (login) VALUES (?)";
        boolean rowInserted = false;
        Connection connection = DataBase.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, users.getLogin());
        rowInserted = statement.executeUpdate() > 0;
        return rowInserted;
    }


    @Override
    public boolean delete(Users o) throws SQLException {
        String sql = "DELETE FROM users where id=?";
        boolean rowDelete = false;
        Connection conn = DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, o.getId());
        return rowDelete = statement.executeUpdate() > 0;
    }

}
