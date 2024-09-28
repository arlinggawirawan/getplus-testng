package com.getplus.automation.tests.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class InAppScanPage {

    private final WebDriverWait wait;

    //locator
    private final By inAppScan = By.xpath("//div[text()='Foto Struk dashboard']");
    private final By inAppScanDefaultHeader = By.xpath("//h4[contains(text(), 'Pending Receipt')]");
    private final By inAppScanFilterAdmin = By.xpath("//input[@value='All Admin']");
    private final By inAppScanSelectAdmin = By.xpath("//div[text()='arlingga.wirawan@gpi.id (Admin)']");
    private final By inAppScanAssertSelectionAdmin = By.className("mantine-Input-input");

    public InAppScanPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickInAppScan() {
        WebElement clickInAppScanPage = waitForElement(inAppScan);
        clickInAppScanPage.click();
    }

   public void assertDefaultHeader() {
    	WebElement assertDefaultHeaderInAppScan = waitForElement(inAppScanDefaultHeader);
    	String headerText = assertDefaultHeaderInAppScan.getText();
    	Assert.assertEquals(headerText, "Pending Receipt", "Assertion failed, header missmatch");
    }

   public void filterAdmin() {
        WebElement clickFilterAdmin = waitForElement(inAppScanFilterAdmin);
        clickFilterAdmin.click();
        WebElement selectAdminName = waitForVisibility(inAppScanSelectAdmin);
        selectAdminName.click();
        WebElement assertSelectionAdmin = waitForVisibility(inAppScanAssertSelectionAdmin);
        String adminText = assertSelectionAdmin.getAttribute("value").trim();  // Get 'value' instead of 'text' for input elements
        System.out.println("Actual admin text: " + adminText);
        Assert.assertEquals(adminText, "arlingga.wirawan@gpi.id (Admin)", "Assertion failed, admin not selected");
   }
}