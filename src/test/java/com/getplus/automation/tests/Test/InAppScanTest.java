package com.getplus.automation.tests.Test;

import org.testng.annotations.Test;
import com.getplus.automation.tests.Base.BaseTest;
import com.getplus.automation.tests.PageObject.InAppScanPage;


public class InAppScanTest extends BaseTest {
	
    @Test(priority = 1)
    public void testInAppScan() {
    	InAppScanPage inAppScanPage = new InAppScanPage(driver);
        inAppScanPage.clickInAppScan();
    }

    @Test(priority = 2)
    public void testDefaultHeader() {
	   	InAppScanPage inAppScanPage = new InAppScanPage(driver);
    	inAppScanPage.assertDefaultHeader();
    }

    @Test(priority = 3)
    public void  testFilterAdmin() throws InterruptedException {
        InAppScanPage inAppScanPage = new InAppScanPage(driver);
        inAppScanPage.filterAdmin();
        Thread.sleep(3000);
    }
}
