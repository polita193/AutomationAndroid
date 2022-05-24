package com.appiumAutomation.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WorkOrdersListPage extends BasePage{

    @FindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")
    private WebElement backXButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Work Orders']")
    private WebElement workOrdersTitle;

    @FindBy(xpath = "//android.widget.EditText")
    private WebElement searchBar;

    @FindBy(xpath = "//android.widget.TextView[@text='Scheduled Service']")
    private WebElement scheduledServiceLabel;

    @FindBy(xpath = "//android.widget.Switch")
    private WebElement scheduledServiceSwitch;

    @FindBy(xpath = "//android.widget.HorizontalScrollView")
    private WebElement scrollFilters;

    @FindBy(xpath = "//android.widget.TextView[@text='Trade']")
    private WebElement tradeLabel;

    @FindBy(xpath = "//android.widget.TextView[@text='Priority']")
    private WebElement priorityLabel;

    @FindBy(xpath = "//android.widget.TextView[@text='Date']")
    private WebElement dateLabel;

    @FindBy(xpath = "android.widget.ScrollView")
    private WebElement scrollWorkOrders;

    @FindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup")
    private List<WebElement> workOrders;

    public WorkOrdersListPage(AppiumDriver driver) {
        super(driver);
    }

    public void waitScreenToLoad(){
        waitForVisibilityOfElement(workOrdersTitle, "Work Orders Title");
    }

    public void goBack(){
        click(backXButton, "X and go back to Home Page");
    }

    public void searchByKeyword(String keyword){
        input(searchBar, keyword, "Searching for Work Order - keyword: "+ keyword);
        //how to validate filtering??
    }
    public void clearSearchBar(){
        clear(searchBar, "Search For a work order Bar");
    }

    public void sortByTrade(){
        waitForVisibilityOfElement(tradeLabel, "Trade column title");
        click(tradeLabel, "Sorting by Trade");
    }

    public void sortByPriority(){
        waitForVisibilityOfElement(priorityLabel, "Priority column title");
        click(priorityLabel, "Sorting by Priority");
    }

    public void sortByDate(){
        waitForVisibilityOfElement(dateLabel, "Date column title");
        click(dateLabel, "Sorting by Date");
    }

    public void selectAWorkOrder(){
        click(workOrders.get(0), "First Work Order");
    }

}
