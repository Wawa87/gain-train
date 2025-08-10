package com.runicdigital.gaintrain;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppContext {
    private Connection dbConnection;

    public void start() {
        try {
            String dbUrl = "jdbc:sqlite:gaintrain.db";
            this.dbConnection = DriverManager.getConnection(dbUrl);


//            this.dbConnection.prepareStatement(String.valueOf(AppContext.class.getResource("schema.sql"))).execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
//        catch (IOException e) {
//            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
//        }
    }

    public Connection getConnection() {
        return this.dbConnection;
    }
}
