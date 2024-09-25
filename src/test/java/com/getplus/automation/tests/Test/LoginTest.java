package com.getplus.automation.tests.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.getplus.automation.tests.Base.BaseTest;
import com.getplus.automation.tests.PageObject.LoginPage;
import com.getplus.automation.tests.Utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        
        ConfigReader config = new ConfigReader();
        String username = config.getUsername();
        String password = config.getPassword();

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Thread.sleep(3000); // Consider using WebDriverWait instead

        String expectedUrl = "https://portal-dev.getplus-app.net/launch";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed, URL mismatch");
        System.out.println("URL matched");
    }
}
