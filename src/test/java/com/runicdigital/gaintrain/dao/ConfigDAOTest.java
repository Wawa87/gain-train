package com.runicdigital.gaintrain.dao;

import com.runicdigital.gaintrain.AppContext;
import com.runicdigital.gaintrain.dao.sqlite.ConfigDAOImpl;
import com.runicdigital.gaintrain.dao.sqlite.UserDAOImpl;
import com.runicdigital.gaintrain.model.User;
import com.runicdigital.gaintrain.model.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ConfigDAOTest {
    @Test
    public void testSaveAndFindConfig() throws SQLException {
        AppContext appContext = new AppContext();
        appContext.start();
        UserDAOImpl userDAO = new UserDAOImpl(appContext.getConnection());
        ConfigDAOImpl configDAO = new ConfigDAOImpl(appContext.getConnection());

        User user = new User();
        user.setNickname("jerry");
        user.setPassword("dev");
        user.setEmail("jerry@seinfeld.com");

        userDAO.saveUser(user);

        Config config0 = new Config();
        config0.setUserId(user.getUserId());
        config0.setCkey("units");
        config0.setCval("kg");
        configDAO.saveConfig(config0);

        Config config1 = new Config();
        config1.setUserId(user.getUserId());
        config1.setCkey("theme");
        config1.setCval("dark");
        configDAO.saveConfig(config1);

        List<Config> configs = configDAO.findAll(user.getUserId());
        Optional<Config> configCheck = configs.stream().filter((it) -> it.getCkey().equals("theme")).findFirst();
        if (configCheck.isPresent()) {
            Assertions.assertTrue(configCheck.get().getCval().equals("dark"));
        } else {
            Assertions.assertTrue(false);
        }

        System.out.println("wait...");
    }
}
