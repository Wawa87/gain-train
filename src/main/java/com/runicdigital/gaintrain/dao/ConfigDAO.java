package com.runicdigital.gaintrain.dao;

import com.runicdigital.gaintrain.model.Config;

import java.sql.SQLException;
import java.util.List;

public interface ConfigDAO {
    void saveConfig(Config config) throws SQLException;
    List<Config> findAll(Long userId) throws SQLException;
}
