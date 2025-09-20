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
    public void testInsertUser() throws SQLException {
        AppContext appContext = new AppContext();
        appContext.start();
        UserDAOImpl userDAO = new UserDAOImpl(appContext.getConnection());

        User user0 = new User();
        user0.setEmail("testuser@test.com");
        user0.setNickname("testNickname");
        user0.setPassword("test123");

        User user1 = new User();
        user1.setEmail("aaa@test.com");
        user1.setNickname("josoej");
        user1.setPassword("so092f");

        userDAO.insertUser(user0);
        userDAO.insertUser(user1);

        Assertions.assertTrue(user0.getUserId() == 1);
        Assertions.assertTrue(user1.getUserId() == 2);
    }

    @Test
    public void testQueryUserById() throws SQLException {
        AppContext appContext = new AppContext();
        appContext.start();
        UserDAOImpl userDAO = new UserDAOImpl(appContext.getConnection());

        User user0 = new User();
        user0.setEmail("testuser@test.com");
        user0.setNickname("testNickname");
        user0.setPassword("test123");

        User user1 = new User();
        user1.setEmail("aaa@test.com");
        user1.setNickname("josoej");
        user1.setPassword("so092f");

        userDAO.insertUser(user0);
        userDAO.insertUser(user1);

        User user0_1 = userDAO.queryUserById(1);
        User user1_1 = userDAO.queryUserById(2);

        Assertions.assertTrue(user0.getUserId() == user0_1.getUserId());
        Assertions.assertTrue(user1.getUserId() == user1_1.getUserId());
    }

    @Test
    public void testQueryUserByEmail() throws SQLException {
        AppContext appContext = new AppContext();
        appContext.start();
        UserDAOImpl userDAO = new UserDAOImpl(appContext.getConnection());

        User user0 = new User();
        user0.setEmail("testuser@test.com");
        user0.setNickname("testNickname");
        user0.setPassword("test123");

        User user1 = new User();
        user1.setEmail("aaa@test.com");
        user1.setNickname("josoej");
        user1.setPassword("so092f");

        userDAO.insertUser(user0);
        userDAO.insertUser(user1);

        User user0_1 = userDAO.queryUserByEmail("testuser@test.com");
        User user1_1 = userDAO.queryUserByEmail("aaa@test.com");

        Assertions.assertTrue(user0.getUserId() == user0_1.getUserId());
        Assertions.assertTrue(user1.getUserId() == user1_1.getUserId());
    }

    @Test
    public void testUpdateUser() throws SQLException {
        AppContext appContext = new AppContext();
        appContext.start();
        UserDAOImpl userDAO = new UserDAOImpl(appContext.getConnection());

        User user0 = new User();
        user0.setEmail("testuser@test.com");
        user0.setNickname("testNickname");
        user0.setPassword("test123");

        userDAO.insertUser(user0);

        user0.setEmail("gains@gaintrain.com");
        user0.setNickname("buff");
        user0.setPassword("supercross09");

        userDAO.updateUser(user0);

        User user1 = userDAO.queryUserById(1);

        Assertions.assertTrue(user0.getEmail().equals(user1.getEmail()));
        Assertions.assertTrue(user0.getNickname().equals(user1.getNickname()));
        Assertions.assertTrue(user0.getPassword().equals(user1.getPassword()));
    }

    @Test
    public void testDeleteUser() throws SQLException {
        AppContext appContext = new AppContext();
        appContext.start();
        UserDAOImpl userDAO = new UserDAOImpl(appContext.getConnection());

        User user0 = new User();
        user0.setEmail("testuser@test.com");
        user0.setNickname("testNickname");
        user0.setPassword("test123");

        userDAO.insertUser(user0);
        userDAO.deleteUser(user0);

        User user1 = userDAO.queryUserById(1);

        Assertions.assertTrue(user1 == null);
    }
}
