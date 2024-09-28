package com.getplus.automation.tests.Test;
	
import org.testng.annotations.Test;
import org.testng.Assert;
import com.getplus.automation.tests.Base.BaseTest;
import com.getplus.automation.tests.PageObject.LogoutPage;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	
public class LogoutTest extends BaseTest {
	
	@Test
	public void testValidLogout() {
		LogoutPage logoutPage = new LogoutPage(driver);
	
	    logoutPage.clickLogoutOption();
	    logoutPage.clickLogout();
	        
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://portal-dev.getplus-app.net/login"));
	        
	    String expectedUrl = "https://portal-dev.getplus-app.net/login";
		System.out.println(expectedUrl);
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Logout failed, URL mismatch");
	}	
}
