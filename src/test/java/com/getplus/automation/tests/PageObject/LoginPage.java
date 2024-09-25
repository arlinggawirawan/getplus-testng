package com.getplus.automation.tests.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.getplus.automation.tests.Utils.ConfigReader;

public class LoginPage {
	private WebDriver driver;
	private ConfigReader configReader;
	
	//locator
	private By usernameField = By.xpath("//input[@placeholder='Email']");
	private By passwordField = By.xpath("//input[@placeholder='Password']");
	private By loginClick = By.xpath("//span[text()='Login']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.configReader = new ConfigReader();
	}
	
	public void enterUsername(String username) {
        WebElement usernameElem = driver.findElement(usernameField);
        usernameElem.sendKeys(configReader.getUsername());
    }

    public void enterPassword(String password) {
        WebElement passwordElem = driver.findElement(passwordField);
        passwordElem.sendKeys(configReader.getPassword());
    }

    public void clickLogin() {
        WebElement loginElem = driver.findElement(loginClick);
        loginElem.click();
    }
}
