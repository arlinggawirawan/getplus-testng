package com.getplus.automation.tests.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    public String getFilterMerchant() {
        return properties.getProperty("filter.merchant");
    }

    public String getFilterLocation() {
        return properties.getProperty("filter.location");
    }

    public String getChromeDriverPath() {
        return properties.getProperty("chrome.driver.path");
    }

    public String getAppUrl() {
        return properties.getProperty("app.url");
    }

    public boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    public String getWindowSize() {
        return properties.getProperty("window.size");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}
