package com.runicdigital.gaintrain.dao.sqlite;

import com.runicdigital.gaintrain.dao.UserDAO;
import com.runicdigital.gaintrain.model.User;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Base64;

public class UserDAOImpl implements UserDAO {
    private static final String insertStr = "INSERT INTO users (email, nickname, password) VALUES (?, ?, ?)";
    private static final String queryStrById = "SELECT * FROM users WHERE user_id=?";
    private static final String queryStrByEmail = "SELECT * FROM users WHERE email=?";
    private static final String updateUserStr = "UPDATE users SET user_id=?, email=?, nickname=?, password=? WHERE user_id=?";
    private static final String deleteUserStr = "DELETE FROM users WHERE user_id=?";
    private Connection dbConnection;

    public UserDAOImpl(Connection connection) {
        this.dbConnection = connection;
    }

    @Override
    public User queryUserById(long userId) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement(queryStrById);
        preparedStatement.setString(1, String.valueOf(userId));
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User user = new User();
            user.setUserId(resultSet.getLong(1));
            user.setEmail(resultSet.getString(2));
            user.setNickname(resultSet.getString(3));
            user.setPassword(resultSet.getString(4));

            resultSet.close();
            preparedStatement.close();
            return user;
        } else {
            resultSet.close();
            preparedStatement.close();
            return null;
        }
    }

    @Override
    public User queryUserByEmail(String email) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement(queryStrByEmail);
        preparedStatement.setString(1, String.valueOf(email));
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User user = new User();
            user.setUserId(resultSet.getLong(1));
            user.setEmail(resultSet.getString(2));
            user.setNickname(resultSet.getString(3));
            user.setPassword(resultSet.getString(4));

            resultSet.close();
            preparedStatement.close();
            return user;
        } else {
            resultSet.close();
            preparedStatement.close();
            return null;
        }
    }

    @Override
    public long insertUser(User user) throws SQLException {
        long result = -1;

        user.setPassword(Base64.getEncoder().encode(user.getPassword().getBytes(StandardCharsets.UTF_8)).toString());

        PreparedStatement preparedStatement = dbConnection.prepareStatement(insertStr, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getNickname());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.execute();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            result = generatedKeys.getLong(1);
            user.setUserId(result);
        }
        generatedKeys.close();
        preparedStatement.close();
        return result;
    }

    @Override
    public long updateUser(User user) throws SQLException {
        long result = -1;
        PreparedStatement preparedStatement = dbConnection.prepareStatement(updateUserStr);
        preparedStatement.setLong(1, user.getUserId());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getNickname());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setLong(5, user.getUserId());
        result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result;
    }

    @Override
    public boolean deleteUser(User user) throws SQLException {
        boolean result = false;
        PreparedStatement preparedStatement = dbConnection.prepareStatement(deleteUserStr);
        preparedStatement.setLong(1, user.getUserId());
        result = preparedStatement.execute();
        preparedStatement.close();
        return result;
    }
}
