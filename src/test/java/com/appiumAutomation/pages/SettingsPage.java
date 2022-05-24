package com.appiumAutomation.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Log Out:')]")
    private WebElement logOut;

    public SettingsPage(AppiumDriver driver) {
        super(driver);
    }

    public void logOut(){
        waitForVisibilityOfElement(logOut, "Log Out");
        click(logOut, "Log Out");
    }
}
