package com.webteam.laptopmall.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyUtil {
    private static final Logger log = Logger.getLogger(PropertyUtil.class.getName());

    private static final String FILE_NAME = "application-prod.properties";

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream(FILE_NAME)) {
            properties.load(inputStream);
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return properties;
    }
}
