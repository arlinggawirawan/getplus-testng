package com.getplus.automation.tests.Base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    
	protected static WebDriver driver;

    @BeforeTest
    public void setup() {
    	
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://portal-dev.getplus-app.net/login");
    }

    @AfterTest
    public void teardown() {
    	
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
