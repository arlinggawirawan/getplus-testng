package com.getplus.automation.tests.PageObject;

import com.getplus.automation.tests.Utils.ConfigReader;
import com.getplus.automation.tests.Utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class InAppScanPage {

    private final WebDriverWait wait;
    private final ConfigReader configReader;

    //locator
    private final By inAppScan = By.xpath("//div[text()='Foto Struk dashboard']");
    private final By inAppScanDefaultHeader = By.xpath("//h4[contains(text(), 'Pending Receipt')]");
    private final By inAppScanFilterAdmin = By.xpath("//input[@value='All Admin']");
    private final By inAppScanSelectAdmin = By.xpath("//div[text()='arlingga.wirawan@gpi.id (Admin)']");
    private final By inAppScanAssertSelectionAdmin = By.className("mantine-Input-input");
    private final By inAppScanInputFilterMerchant = By.xpath("//input[@placeholder='Merchant']");
    private final By inAppScanInputFilterLocation = By.xpath("//input[@placeholder='Location']");
    private final By inAppScanInputFilterEmail = By.xpath("//input[@placeholder='Email']");
    private final By inAppScanFilterSubmitButton = By.xpath("//span[text()='Submit']");

    public InAppScanPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.configReader = new ConfigReader();
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

    public void applyRandomCaseFilter() {
        String randomizedMerchantFilter = StringUtils.randomizeCase(configReader.getFilterMerchant());
        String randomizedLocationFilter = StringUtils.randomizeCase(configReader.getFilterLocation());
        String randomizedEmailFilter = StringUtils.randomizeCase(configReader.getFilterEmail());
        filterReceiptMerchant(randomizedMerchantFilter);
        filterReceiptLocation(randomizedLocationFilter);
        filterReceiptEmail(randomizedEmailFilter);
    }

   public void filterReceiptMerchant(String filter) {
       WebElement inputFilterMerchant = waitForElement(inAppScanInputFilterMerchant);
       inputFilterMerchant.clear();
       inputFilterMerchant.sendKeys(filter);
    }

   public void filterReceiptLocation(String filter) {
       WebElement inputFilterLocation = waitForElement(inAppScanInputFilterLocation);
       inputFilterLocation.clear();
       inputFilterLocation.sendKeys(filter);
   }

   public void filterReceiptEmail(String filter) {
        WebElement inputFilterEmail = waitForElement(inAppScanInputFilterEmail);
        inputFilterEmail.clear();
        inputFilterEmail.sendKeys(filter);
        WebElement clickFilterSubmitButton = waitForElement(inAppScanFilterSubmitButton);
        clickFilterSubmitButton.click();
   }
}