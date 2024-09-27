package com.getplus.automation.tests.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private final WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locator
	private final By usernameField = By.xpath("//input[@placeholder='Email']");
	private final By passwordField = By.xpath("//input[@placeholder='Password']");
	private final By loginClick = By.xpath("//span[text()='Login']");
	
	public void enterUsername(String username) {
        WebElement usernameElem = driver.findElement(usernameField);
        usernameElem.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElem = driver.findElement(passwordField);
        passwordElem.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginElem = driver.findElement(loginClick);
        loginElem.click();
    }
}
