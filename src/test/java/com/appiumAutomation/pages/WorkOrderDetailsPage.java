package com.appiumAutomation.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WorkOrderDetailsPage extends BasePage{

    @FindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")
    private WebElement backXButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Work Order Details']")
    private WebElement workOrdersDetailsTitle;

    @FindBy(className = "android.widget.ScrollView")
    private WebElement scrollView;

    @FindBy(xpath = "//android.widget.TextView[@text='Status']")
    private WebElement statusLabel;

    @FindBy(xpath = "//android.view.ViewGroup[1]/android.widget.TextView[5]")
    private WebElement statusValue;

    @FindBy(xpath = "//android.widget.TextView[@text='Provider Details']")
    private WebElement providerDetailsLabel;

    @FindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[3]")
    private WebElement providerDetailsValue;

    @FindBy(xpath = "//android.widget.TextView[@text='Details']")
    private WebElement detailsLabel;

    @FindBy(xpath = "//android.widget.TextView[@text='Recent Notes']")
    private WebElement recentNotesLabel;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")
    private WebElement addNoteButton;

    @FindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[4]")
    private WebElement viwAllNotesLink;

    @FindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup")
    private WebElement escalateWorkOrderButton;

    public WorkOrderDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    public void waitScreenToLoad(){
        waitForVisibilityOfElement(workOrdersDetailsTitle, "Work Order Details Title");
    }

    public void goBack(){
        click(backXButton, "X and go back to Work Order List page");
    }

    public void validateLabels(){
        validateContent(statusLabel,"Status", "Status label");
        validateContent(providerDetailsLabel,"Provider Details", "Provider Details label");
        validateContent(detailsLabel,"Details", "Details label");
    }
    public void validateStatus(){
        validateContent(statusValue, "OPEN", "Status value");
    }

    public void validateProvider(){
        validateContent(providerDetailsValue, "Home Office Insource Hotline", "Provider Details value");
    }

    //NEEDS REVIEW :(
    public void scrollDownToAddNote(){
        waitForElementToBeClickable(escalateWorkOrderButton, "Escalate Work order button");
        scrollToBottom(viwAllNotesLink, "Add Notes button");
        click(addNoteButton, "Add Notes");
        waitForVisibilityOfElement(recentNotesLabel, "Recent Note label");
        waitForVisibilityOfElement(viwAllNotesLink, "link");
        waitForElementToBeClickable(addNoteButton, "Add Notes button");
        click(addNoteButton, "Add Notes");
    }




}
