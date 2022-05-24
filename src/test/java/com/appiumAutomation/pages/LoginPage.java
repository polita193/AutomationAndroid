package com.appiumAutomation.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

 @FindBy(id = "com.walmart.sso.app:id/textView")
 private WebElement titleLayout;
 @FindBy(id = "com.walmart.sso.app:id/userid")
 private WebElement userIDTextField;
 @FindBy(id = "com.walmart.sso.app:id/password")
 private WebElement passwordTextField;
 @FindBy(id = "com.walmart.sso.app:id/domain")
 private WebElement domain;
 @FindBy(id = "com.walmart.sso.app:id/site_id")
 private WebElement siteId;
 @FindBy(id = "com.walmart.sso.app:id/country")
 private WebElement country;
 @FindBy(id = "com.walmart.sso.app:id/sign_in")
 private WebElement loginButton;


 public LoginPage(AppiumDriver driver) {
  super(driver);
 }

 public void waitAppToLoad(){
  waitForVisibilityOfElement(titleLayout, "Please Sign In layout");
 }

 public void enterEmailID(String username) {
  input(userIDTextField, username, "userid");
 }

 public void enterPassword(String password) {
  input(passwordTextField, password, "password");
 }

 public void enterSiteId(String site){
  input(siteId, site, "store/club#");
 }

 public void clickOnSignInButton() {
  waitForVisibilityOfElement(loginButton, "Sign in button");
  click(loginButton, "Sign in button");
 }

 public void loginToTheApp(String email, String pwd, String siteId) {
 enterEmailID(email);
 enterPassword(pwd);
 enterSiteId(siteId);
 clickOnSignInButton();
 }

}