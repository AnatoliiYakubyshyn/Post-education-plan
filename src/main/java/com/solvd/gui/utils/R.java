package com.solvd.gui.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class R {

    private static final Logger LOGGER = LogManager.getLogger(R.class);
    public static Object getConfigParameter(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        }
        catch (IOException e) {
            LOGGER.error(e);
        }
        return properties.get(key);
    }
}
