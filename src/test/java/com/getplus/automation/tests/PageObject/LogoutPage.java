package com.getplus.automation.tests.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	
	private final WebDriver driver;
	
	//locator
	private final By logoutOption = By.xpath("//img[@src='/assets/chevron-right-76a61bf1.svg']");
	private final By logoutClick = By.xpath("//span[contains(text(), 'Logout')]");
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogoutOption() {
        WebElement clickLogout = driver.findElement(logoutOption);
        clickLogout.click();
    }

    public void clickLogout() {
        WebElement clickLogoutButton = driver.findElement(logoutClick);
        clickLogoutButton.click();
    }
}
