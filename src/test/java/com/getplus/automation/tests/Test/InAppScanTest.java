package com.getplus.automation.tests.Test;

import com.getplus.automation.tests.Utils.CustomTestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.getplus.automation.tests.Base.BaseTest;
import com.getplus.automation.tests.PageObject.InAppScanPage;

@Listeners(CustomTestListener.class)
public class InAppScanTest extends BaseTest {
    private InAppScanPage inAppScanPage;

    @BeforeMethod
    public void setUp() {
        inAppScanPage = new InAppScanPage(driver);
    }

    @Test(priority = 1)
    public void testInAppScan() {
        inAppScanPage.clickInAppScan();
    }

    @Test(priority = 2)
    public void testDefaultHeader() {
    	inAppScanPage.assertDefaultHeader();
    }

    @Test(priority = 4)
    public void  testFilterAdmin() throws InterruptedException {
        inAppScanPage.filterAdmin();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void testFilterReceipt() {
        inAppScanPage.applyRandomCaseFilter();
    }
}
