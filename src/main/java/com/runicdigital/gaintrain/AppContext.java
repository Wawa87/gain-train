package com.runicdigital.gaintrain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class AppContext {
    private Connection connection;
    private static final Logger LOGGER = LoggerFactory.getLogger(AppContext.class);

    public void start() {
        try {
            String dbUrl = "jdbc:sqlite:gaintrain.db";
            this.connection = DriverManager.getConnection(dbUrl);

            InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("schema.sql");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(systemResourceAsStream, StandardCharsets.UTF_8));

            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            String sqlDDL = stringBuffer.toString();
            String[] statements = sqlDDL.split(";");
            try (Statement stmt = this.connection.createStatement()) {
                for (String statement : statements) {
                    String trimmed = statement.trim();
                    if (!trimmed.isEmpty()) {
                        ((Statement) stmt).execute(trimmed);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
