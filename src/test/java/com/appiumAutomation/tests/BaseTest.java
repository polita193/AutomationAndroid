package com.appiumAutomation.tests;

import com.appiumAutomation.utils.listeners.TestListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

@Listeners({TestListener.class})
public class BaseTest {
    public static AppiumDriver driver;
    static Properties props;
    @DataProvider(name = "credentials")
    public static Object[][] credentials() {
        return new Object[][]{{props.getProperty("userName"),  props.getProperty("password"), props.getProperty("storeId")}};
    }

    @BeforeClass
    public void setUp() {
        setLocalMobileDriver("android");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    public AppiumDriver getDriver() {
        return driver;
    }
    private void setLocalMobileDriver(String browserName) {
        loadProperties();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        try {
            if(browserName.equalsIgnoreCase("android")){
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, props.getProperty("platformName"));
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, props.getProperty("platformVersion"));
                capabilities.setCapability(MobileCapabilityType.UDID, props.getProperty("udid"));
                //capabilities.setCapability(MobileCapabilityType.APP,props.getProperty("app"));
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,props.getProperty("androidDeviceName"));
                capabilities.setCapability("appPackage",props.getProperty("appPackage"));
                capabilities.setCapability("appActivity",props.getProperty("appActivity"));
                capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT,"true");

                driver = new AppiumDriver(new URL(props.getProperty("appiumUrl")), capabilities);
            }else if(browserName.equalsIgnoreCase("iphone")){}
        } catch (MalformedURLException e) {
            System.out.println("Cause is:" + e.getCause());
            System.out.println("Message is:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadProperties() {
        if(driver == null){
            FileInputStream fs = null;
            props = new Properties();
            try {
                fs = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
                props.load(fs);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fs != null)
                        fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
