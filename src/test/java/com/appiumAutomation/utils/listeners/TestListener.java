package com.appiumAutomation.utils.listeners;

import com.appiumAutomation.tests.BaseTest;
import com.appiumAutomation.utils.extentreports.ExtentManager;
import com.appiumAutomation.utils.logs.Log;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Objects;

import static com.appiumAutomation.utils.extentreports.ExtentTestManager.getTest;

public class TestListener extends BaseTest implements ITestListener {

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }
    public String attachImages(ITestResult result) {
        AppiumDriver driver = ((BaseTest)result.getInstance()).getDriver();
        return "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info(getTestMethodName(result) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(getTestMethodName(result)+ " test succeed");
        getTest().log(Status.PASS, "Test Passed",
                getTest().addScreenCaptureFromBase64String(attachImages(result)).getModel().getMedia().get(0));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info(getTestMethodName(result)+ " test failed");
        getTest().log(Status.FAIL, result.getThrowable());
        getTest().log(Status.FAIL, "Test Failed",
                getTest().addScreenCaptureFromBase64String(attachImages(result)).getModel().getMedia().get(0));

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info(getTestMethodName(result) + " test skipped.");
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("Method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("Method " + iTestContext.getName());
        ExtentManager.extentReports.flush();
    }
}
