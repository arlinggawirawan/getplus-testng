package com.getplus.automation.tests.Base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    
	protected static WebDriver driver;
    private Properties properties = new Properties();

    @BeforeTest
    public void setup() {
    	try {
            FileInputStream configFile = new FileInputStream("src/test/resources/config.properties");
            properties.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver.path"));
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(properties.getProperty("headless"))) {
            options.addArguments("--headless"); // Run in headless mode
            options.addArguments("--disable-gpu"); // Disable GPU hardware acceleration (optional)
            options.addArguments("--window-size=" + properties.getProperty("window.size"));
        }
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(properties.getProperty("app.url"));
    }

    @AfterTest
    public void teardown() {
    	
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
