package com.getplus.automation.tests.Test;

import com.getplus.automation.tests.Base.BaseTest;
import com.getplus.automation.tests.PageObject.LoginPage;
import com.getplus.automation.tests.Utils.ConfigReader;
import com.getplus.automation.tests.Utils.CustomTestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Listeners(CustomTestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        
        ConfigReader config = new ConfigReader();
        String username = config.getUsername();
        String password = config.getPassword();

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://portal-dev.getplus-app.net/launch"));

        String expectedUrl = "https://portal-dev.getplus-app.net/launch";
        System.out.println(expectedUrl);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed, URL mismatch");
    }
}
