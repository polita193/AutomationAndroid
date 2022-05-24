package com.appiumAutomation.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//android.widget.ImageView)[1]")
    private WebElement fixitTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Submitted Issues']")
    private WebElement submittedIssuesLabel;

    @FindBy(xpath = "//android.widget.TextView[@text='Work Orders']")
    private WebElement workOrdersLabel;

    @FindBy(xpath = "(//android.widget.TextView[contains(@text,'View All')])[1]")
    private WebElement workOrdersViewAll;

    @FindBy(xpath = "//android.widget.TextView[@text='Technology Tickets']")
    private WebElement technologyTicketsLabel;

    @FindBy(xpath = "(//android.widget.TextView[contains(@text,'View All')])[2]")
    private WebElement technologyTicketsViewAll;
    @FindBy(xpath = "(//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]")
    private WebElement submitAnIssueButton;

    @FindBy(xpath = "(//android.view.ViewGroup[3]/android.view.ViewGroup[3])[2]")
    private WebElement settings;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void waitScreenToLoad(){
        waitForVisibilityOfElement(fixitTitle, "Fixit Title");
    }

    public void validateLabelsPresence() {
        waitForVisibilityOfElement(submittedIssuesLabel, "Submitted Issues label");
        validateContent(submittedIssuesLabel, "Submitted Issues", "Submitted Issues label");
        waitForVisibilityOfElement(workOrdersLabel, "Work Orders label");
        validateContent(workOrdersLabel, "Work Orders", "Work Orders label");
    }

    public void clickViewAllWorkOrder(){
        waitForVisibilityOfElement(workOrdersViewAll, "View all Work Orders link");
        click(workOrdersViewAll, "View all Work Orders link");
    }

    public void clickSubmitAnIssueButton(){
        waitForVisibilityOfElement(submitAnIssueButton, "SUBMIT AN ISSUE button");
        click(submitAnIssueButton, "SUBMIT AN ISSUE button");
    }

    public void goToSettings(){
        waitForVisibilityOfElement(settings, "Settings");
        click(settings, "Settings");
    }
}
