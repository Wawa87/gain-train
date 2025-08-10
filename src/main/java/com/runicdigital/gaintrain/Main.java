package com.runicdigital.gaintrain;

import com.runicdigital.gaintrain.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.info("All aboard the GainTrain...");

//        AppContext appContext = new AppContext();
//        appContext.start();
    }

    public static void run() {
        User user = new User();
            user.setEmail("hotshopper@protonmail.com");
            user.setNickname("");
    }
}