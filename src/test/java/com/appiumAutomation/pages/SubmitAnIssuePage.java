package com.appiumAutomation.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubmitAnIssuePage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text='Submit an issue']")
    private WebElement submitAnIssueTitle;
    public SubmitAnIssuePage(AppiumDriver driver) {
        super(driver);
    }

    public void waitScreenToLoad(){
        waitForVisibilityOfElement(submitAnIssueTitle, "Submit an issue Title");
    }
}
