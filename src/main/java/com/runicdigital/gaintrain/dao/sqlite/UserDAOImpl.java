package com.runicdigital.gaintrain.dao.sqlite;

import com.runicdigital.gaintrain.dao.UserDAO;
import com.runicdigital.gaintrain.model.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    private static final String insertStr = "INSERT INTO users (email, nickname, password) VALUES (?, ?, ?)";
    private Connection dbConnection;

    public UserDAOImpl(Connection connection) {
        this.dbConnection = connection;
    }

    @Override
    public User queryUserById(long userId) {
        return null;
    }

    @Override
    public User queryUserByEmail(String email) {
        return null;
    }

    @Override
    public long insertUser(User user) throws SQLException {
        long result = -1;
        PreparedStatement preparedStatement = dbConnection.prepareStatement(insertStr, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(0, user.getEmail());
        preparedStatement.setString(1, user.getNickname());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.execute();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            result = generatedKeys.getLong(0);
            user.setUserId(result);
        }
        generatedKeys.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(User user) {
        return 0;
    }
}
