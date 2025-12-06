package com.runicdigital.gaintrain.dao.sqlite;

import com.runicdigital.gaintrain.dao.ConfigDAO;
import com.runicdigital.gaintrain.model.Config;
import com.runicdigital.gaintrain.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigDAOImpl implements ConfigDAO {
    private static final String insertStr = "INSERT INTO config (user_id, ckey, cval) VALUES (?, ?, ?)";
    private static final String findAllByUserIdStr = "SELECT * FROM config WHERE user_id=?";
    private Connection dbConnection;

    public ConfigDAOImpl(Connection connection) {
        this.dbConnection = connection;
    }

    @Override
    public void saveConfig(Config config) throws SQLException {
        Long result = Long.valueOf(-1);

        PreparedStatement preparedStatement = dbConnection.prepareStatement(insertStr, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, config.getUserId().toString());
        preparedStatement.setString(2, config.getCkey());
        preparedStatement.setString(3, config.getCval());
        preparedStatement.execute();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            result = generatedKeys.getLong(1);
            config.setId(result);
        }
        generatedKeys.close();
        preparedStatement.close();
    }

    @Override
    public List<Config> findAll(Long userId) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement(findAllByUserIdStr);
        preparedStatement.setString(1, String.valueOf(userId));
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Config> configs = new ArrayList<>();
        while (resultSet.next()) {
            Config config = new Config();
            config.setId(resultSet.getLong(1));
            config.setUserId(resultSet.getLong(2));
            config.setCkey(resultSet.getString(3));
            config.setCval(resultSet.getString(4));

            configs.add(config);
        }
        resultSet.close();
        preparedStatement.close();
        return configs;
    }
}
