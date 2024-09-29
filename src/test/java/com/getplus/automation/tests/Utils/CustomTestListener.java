package com.getplus.automation.tests.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Code to execute before a test starts
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not often used
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to execute before the start of a suite/test
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code to execute after the end of a suite/test
    }
}