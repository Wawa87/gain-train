package com.runicdigital.gaintrain.dao;

import com.runicdigital.gaintrain.AppContext;
import com.runicdigital.gaintrain.dao.sqlite.UserDAOImpl;
import com.runicdigital.gaintrain.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAOTest {
    @Test
    public void testInsertUser() throws SQLException {
        User user = new User();
        user.setNickname("hotShopper");
        user.setEmail("hotshopper@protonmail.com");
        user.setPassword("dev123");

        AppContext appContext = new AppContext();
        appContext.start();

        Connection connection = appContext.getConnection();
        UserDAOImpl userDAO = new UserDAOImpl(connection);
        userDAO.insertUser(user);

        Assertions.assertTrue(user.getUserId() > 0, "Assert userId > 0");
    }
}
