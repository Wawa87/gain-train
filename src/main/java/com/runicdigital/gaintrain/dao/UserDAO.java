package com.runicdigital.gaintrain.dao;

import com.runicdigital.gaintrain.model.User;

import java.sql.SQLException;

public interface UserDAO {
    public User queryUserById(long userId) throws SQLException;
    public User queryUserByEmail(String email) throws SQLException;
    public long insertUser(User user) throws SQLException;
    public long updateUser(User user) throws SQLException;
    public boolean deleteUser(User user) throws SQLException;
}
