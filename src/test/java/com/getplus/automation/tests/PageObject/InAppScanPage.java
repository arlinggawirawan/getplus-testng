package com.getplus.automation.tests.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class InAppScanPage {

    private final WebDriver driver;

    //locator
    private final By inAppScan = By.xpath("//div[text()='Foto Struk dashboard']");
    private final By inAppScanDefaultHeader = By.xpath("//h4[contains(text(), 'Pending Receipt')]");
    

    public InAppScanPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickInAppScan() {   	
 
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickInAppScanPage = wait.until(ExpectedConditions.presenceOfElementLocated(inAppScan));
        clickInAppScanPage.click();
        
    }
        
   public void assertDefaultHeader() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement assertDefaultHeaderInAppScan = wait.until(ExpectedConditions.visibilityOfElementLocated(inAppScanDefaultHeader));
    	String headerText = assertDefaultHeaderInAppScan.getText();
    	Assert.assertEquals(headerText, "Pending Receipt", "Assertion failed, header missmatch");
    }
}