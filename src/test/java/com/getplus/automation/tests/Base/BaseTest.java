package com.getplus.automation.tests.Base;

import com.getplus.automation.tests.Utils.ConfigReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class BaseTest {
    
	protected static WebDriver driver;

    @BeforeTest
    public void setup() {
        ConfigReader configReader = new ConfigReader();
        System.setProperty("webdriver.chrome.driver", configReader.getChromeDriverPath());

        ChromeOptions options = new ChromeOptions();
        if (configReader.isHeadless()) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=" + configReader.getWindowSize());
        }
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(configReader.getAppUrl());
    }

    @AfterTest
    public void teardown() {
    	
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
