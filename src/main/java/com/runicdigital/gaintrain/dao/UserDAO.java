package com.runicdigital.gaintrain.dao;

import com.runicdigital.gaintrain.model.User;

import java.sql.SQLException;

public interface UserDAO {
    public User queryUserById(long userId);
    public User queryUserByEmail(String email);
    public long insertUser(User user) throws SQLException;
    public int updateUser(User user);
    public int deleteUser(User user);
}
