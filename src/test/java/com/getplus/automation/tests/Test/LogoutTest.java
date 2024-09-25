package com.getplus.automation.tests.Test;
	
import org.testng.Assert;
import org.testng.annotations.Test;
import com.getplus.automation.tests.Base.BaseTest;
import com.getplus.automation.tests.PageObject.LogoutPage;
	
public class LogoutTest extends BaseTest {
	
	@Test
	public void testValidLogout() throws InterruptedException {
		LogoutPage logoutPage = new LogoutPage(driver);
	
	    logoutPage.clickLogoutOption();
	    logoutPage.clickLogout();
	        
	    Thread.sleep(3000);
	        
	    String expectedUrl = "https://portal-dev.getplus-app.net/login";
	    Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Logout failed, URL mismatch");
	    System.out.println("URL matched");    
	}	
}
