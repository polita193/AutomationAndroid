package com.appiumAutomation.tests;

import static com.appiumAutomation.utils.extentreports.ExtentTestManager.startTest;

import com.appiumAutomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FixitTest extends BaseTest {

	@Test(dataProvider = "credentials")
	public void loginToAppTest(Method method, String user, String password, String siteId) {
        startTest(method.getName(), "Login to the app and Validate Home Page");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.waitAppToLoad();
        loginPage.loginToTheApp(user,password, siteId);
        HomePage homePage = new HomePage(getDriver());
        homePage.waitScreenToLoad();
        homePage.validateLabelsPresence();
    }
    @Test(priority = 6)
    public void logoutTest(Method method){
        startTest(method.getName(), "Log out of the app");
        HomePage homePage = new HomePage(getDriver());
        homePage.waitScreenToLoad();
        homePage.goToSettings();
        SettingsPage settingsPage = new SettingsPage(getDriver());
        settingsPage.logOut();
    }

    @Test(priority = 1)
    public void viewAllWorkOrders(Method method){
        startTest(method.getName(), "View all Work Orders and validate filters and sorting");
        HomePage homePage = new HomePage(getDriver());
        homePage.waitScreenToLoad();
        homePage.clickViewAllWorkOrder();
        WorkOrdersListPage workOrdersListPage = new WorkOrdersListPage(getDriver());
        workOrdersListPage.waitScreenToLoad();
        workOrdersListPage.sortByTrade();
        workOrdersListPage.sortByDate();
        workOrdersListPage.sortByPriority();
        workOrdersListPage.searchByKeyword("locksmith");
        workOrdersListPage.clearSearchBar();
    }

    @Test(priority = 2)
    public void viewWorkOrderDetails(Method method){
        startTest(method.getName(), "Select one Work Order and validate its details");
        WorkOrdersListPage workOrdersListPage = new WorkOrdersListPage(getDriver());
        workOrdersListPage.waitScreenToLoad();
        workOrdersListPage.selectAWorkOrder();
        WorkOrderDetailsPage workOrderDetailsPage = new WorkOrderDetailsPage(getDriver());
        workOrderDetailsPage.waitScreenToLoad();
        workOrderDetailsPage.validateLabels();
        workOrderDetailsPage.validateStatus();
        workOrderDetailsPage.validateProvider();
    }

    @Test(priority = 3)
    public void addNoteToWorkOrderDetails(Method method){
        startTest(method.getName(), "Add a note to the Work Order");;
        WorkOrderDetailsPage workOrderDetailsPage = new WorkOrderDetailsPage(getDriver());
        workOrderDetailsPage.waitScreenToLoad();
        workOrderDetailsPage.scrollDownToAddNote();
        AddNotePage addNotePage = new AddNotePage(getDriver());
        addNotePage.waitScreenToLoad();
        addNotePage.addComment();
        addNotePage.cancelComment();
    }

    @Test(priority = 4)
    public void goBackToHomeFromWorkOrderDetails(Method method){
        startTest(method.getName(), "Go back to Home Page from Work Order Details");
        WorkOrderDetailsPage workOrderDetailsPage = new WorkOrderDetailsPage(getDriver());
        workOrderDetailsPage.waitScreenToLoad();
        workOrderDetailsPage.goBack();
        WorkOrdersListPage workOrdersListPage = new WorkOrdersListPage(getDriver());
        workOrdersListPage.waitScreenToLoad();
        workOrdersListPage.goBack();
    }

    @Test(priority = 5, enabled= false)
    public void submitAnIssueTest(Method method){
        startTest(method.getName(), "Submit an issue");
        HomePage homePage = new HomePage(getDriver());
        homePage.waitScreenToLoad();
        homePage.clickSubmitAnIssueButton();
        SubmitAnIssuePage submitAnIssuePage = new SubmitAnIssuePage(getDriver());
        submitAnIssuePage.waitScreenToLoad();
    }

}

