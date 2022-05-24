package com.appiumAutomation.pages;

import com.appiumAutomation.utils.logs.Log;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.PerformsTouchActions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;

import static com.appiumAutomation.utils.extentreports.ExtentTestManager.getTest;


public class BasePage {

    private static final int TIMEOUT = 50;
    protected AppiumDriver driver;
    private WebDriverWait wait;

    public BasePage(AppiumDriver driver){
      this.driver =driver;
      wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
      PageFactory.initElements(driver, this);
    }

    public void waitForVisibilityOfElement(WebElement element, String desc) {
        try {
            Log.info("Waiting for element "+ desc +" visibility");
            wait.until(ExpectedConditions.visibilityOf(element));
            getTest().log(Status.PASS,"Waiting for "+desc +" to be visible ");
        }catch (TimeoutException exception){
            Log.error(exception.getMessage());
            getTest().log(Status.FAIL,exception);
        }
    }
    public void waitForElementToBeClickable(WebElement element, String desc) {
        try {
            Log.info("Waiting for element "+ desc +" to be clickable");
            wait.until(ExpectedConditions.elementToBeClickable(element));
            getTest().log(Status.PASS,"Waiting for "+desc +" to be clickable ");
        }catch (TimeoutException exception){
            Log.error(exception.getMessage());
            getTest().log(Status.FAIL,exception);
        }
    }

    public void input(WebElement element, String data, String description){
        Log.info("Field: "+description+" value: "+ data);
        element.clear();
        element.sendKeys(data);
        getTest().log(Status.PASS,"Field: "+description+" value: "+ data);
    }

    public void click(WebElement element, String description){
        element.click();
        Log.info("Click "+description);
        getTest().log(Status.PASS, "Click "+description);
    }

    public void clear(WebElement element, String description){
        element.clear();
        Log.info("Clear"+description);
        getTest().log(Status.PASS, "Clear "+description);
    }

    public void scrollToBottom(WebElement element, String description){
        Log.info("scrolling to "+description);
        TouchActions action = new TouchActions(driver);
        action.scroll(element, 10, 100);
        action.perform();
        getTest().log(Status.PASS, "scrollling to "+description);
    }

    public void validateContent(WebElement element, String expectedData, String description){
        Log.info("Validating "+ description);
        Assert.assertEquals(element.getText(), expectedData);
        getTest().log(Status.PASS, "Validated "+ description);
    }
}
