package com.appiumAutomation.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNotePage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text='Work Order Update']")
    private WebElement addNoteTitle;

    @FindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")
    private WebElement backXButton;
    @FindBy(xpath = "//android.view.ViewGroup/android.widget.EditText")
    private WebElement commentTextField;

    @FindBy(xpath = "//android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement addPhotoButton;

    @FindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup[2]")
    private WebElement nextButton;

    @FindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup[1]")
    private WebElement cancelButton;


    public AddNotePage(AppiumDriver driver) {
        super(driver);
    }

    public void waitScreenToLoad(){
        waitForVisibilityOfElement(addNoteTitle, "Work Orders Update title");
    }

    public void addComment(){
        input(commentTextField, "This is my first comment", "Adding a comment");
    }

    public void goBack(){
        click(backXButton, "X and go back to Work Order Details");
    }

    public void cancelComment(){
        click(cancelButton, "Cancel adding a comment");
    }
}
