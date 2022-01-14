package com.st1ch.andersenWeb.dao;

import com.st1ch.andersenWeb.config.DataBase;
import com.st1ch.andersenWeb.models.Roles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleDAO implements DAO<Roles, Long> {
    public RoleDAO() {

    }

    public static class SingletonHelper {
        private static final RoleDAO INSTANCE = new RoleDAO();
    }

    public static RoleDAO getInstance() {
        return RoleDAO.SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<Roles> find(Long id) throws SQLException {
        String sql = "SELECT * FROM roles WHERE id = (?)";
        long role_id = 0L;
        String name = "";

        Connection connection = DataBase.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()) {
            role_id = resultSet.getInt("id");
            name = resultSet.getString("name");
        }
        return Optional.of(new Roles(name));
    }

    @Override
    public List<Roles> findAll() throws SQLException {
        List<Roles> listRoles = new ArrayList<Roles>();
        String sql = "SELECT * FROM roles";

        Connection conn = DataBase.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            UserDAO userDAO = new UserDAO();
            String name = resultSet.getString("name");

            Roles roles = new Roles();
            roles.setName(name);
//            roles.setUsers(userDAO.find());
            listRoles.add(roles);
        }
        return listRoles;
    }

    @Override
    public boolean save(Roles o) throws SQLException {
        String sql = "INSERT into roles (name) VALUES (?)";
        return row(o, sql);
    }

    @Override
    public boolean update(Roles o) throws SQLException {
        String sql = ("UPDATE roles SET name=?");
        sql += "WHERE id=?";
        return row(o, sql);
    }

    private boolean row(Roles o, String sql) throws SQLException {
        boolean rowUpdate = false;

        Connection conn = DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, o.getName());

        return rowUpdate = statement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(Roles o) throws SQLException {
        String sql = "DELETE FROM roles where id=?";
        boolean rowDelete = false;
        Connection conn = DataBase.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, o.getId());
        return rowDelete = statement.executeUpdate() > 0;
    }
}


