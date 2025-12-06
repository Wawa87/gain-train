package com.runicdigital.gaintrain.dao;

import com.runicdigital.gaintrain.model.User;

import java.sql.SQLException;

public interface UserDAO {
    public User findUserById(Long userId) throws SQLException;
    public User findUserByEmail(String email) throws SQLException;
    public long saveUser(User user) throws SQLException;
    public long updateUser(User user) throws SQLException;
    public boolean deleteUser(User user) throws SQLException;
}
