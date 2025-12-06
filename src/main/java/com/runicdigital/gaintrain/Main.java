package com.runicdigital.gaintrain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        LOGGER.info("All aboard the GainTrain...");

        AppContext appContext = new AppContext();
        appContext.start();
        run();
    }

    public static void run() {
        System.out.println("Pause...");
    }
}