package com.getplus.automation.tests.Base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    
	protected static WebDriver driver;

    @BeforeSuite
    public void setup() {
    	
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        
        ChromeOptions options = new ChromeOptions();
        String chromeProfilePath = "/Users/arlingga/Library/Application Support/Google/Chrome/Default";
        options.addArguments("user-data-dir=" + chromeProfilePath);
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://portal-dev.getplus-app.net/login");
    }

    @AfterSuite
    public void teardown() {
    	
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
