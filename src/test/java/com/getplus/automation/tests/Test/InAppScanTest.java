package com.getplus.automation.tests.Test;

import org.testng.annotations.Test;
import com.getplus.automation.tests.Base.BaseTest;
import com.getplus.automation.tests.PageObject.InAppScanPage;


public class InAppScanTest extends BaseTest {
	
    @Test(priority = 1)
    public void testInAppScan() throws InterruptedException {
    	InAppScanPage inAppScanPage = new InAppScanPage(driver);
        inAppScanPage.clickInAppScan();
        Thread.sleep(3000);
    }
    
   @Test (priority = 2)
    public void testDefaultHeader() {
	   	InAppScanPage inAppScanPage = new InAppScanPage(driver);
    	inAppScanPage.assertDefaultHeader();
    }
}
