package com.runicdigital.gaintrain.dao;

import com.runicdigital.gaintrain.AppContext;
import com.runicdigital.gaintrain.AppContextTest;
import com.runicdigital.gaintrain.dao.sqlite.UserDAOImpl;
import com.runicdigital.gaintrain.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class UserDAOTest {
    @Test
    public void testInsertUser() {
        AppContext appContext = new AppContext();
        appContext.start();

        User user = new User();
        user.setUserId(1);
        user.setEmail("testuser@test.com");
        user.setNickname("testNickname");
        user.setPassword("test123");

        UserDAOImpl userDAO = new UserDAOImpl(appContext.getConnection());
        try {
            userDAO.insertUser(user);
            Assertions.assertTrue(user.getUserId() > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
