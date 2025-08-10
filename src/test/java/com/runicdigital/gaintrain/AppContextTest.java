package com.runicdigital.gaintrain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppContextTest {
    @Test
    public void testAppContext() {
        AppContext appContext = new AppContext();
        appContext.start();
        Assertions.assertTrue(null != appContext.getConnection());
    }
}
