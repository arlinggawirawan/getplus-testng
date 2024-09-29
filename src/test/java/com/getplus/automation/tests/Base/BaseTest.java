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
    private static final Duration IMPLICIT_WAIT_DURATION = Duration.ofSeconds(30);

    @BeforeTest
    public void setup() {
        ConfigReader configReader = new ConfigReader();
        System.setProperty("webdriver.chrome.driver", configReader.getChromeDriverPath());

        ChromeOptions options = new ChromeOptions();
        if (configReader.isHeadless()) {
            options.addArguments("--headless", "--disable-gpu", "--window-size=" + configReader.getWindowSize());
        }
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_DURATION);
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
