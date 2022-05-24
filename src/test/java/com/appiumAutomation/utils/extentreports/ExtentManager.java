package com.appiumAutomation.utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports() throws IOException {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("dd:MMM:yyyy:HH:mm:ss");
        String file=ft.format(dNow);
        String filename=file.replace(":","_").replace(" ","_")+".html";
        filename="FIXIT_AUTOMATION_"+filename;
        ExtentSparkReporter spark = new ExtentSparkReporter((System.getProperty("user.dir"))+"/advanceReports//"+filename);
        spark.loadXMLConfig(new File(System.getProperty("user.dir")+"/reportsConfig.xml"));
        extentReports.attachReporter(spark);
        return extentReports;
    }
}
