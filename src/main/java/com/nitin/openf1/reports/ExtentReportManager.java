package com.nitin.openf1.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReportManager {
    private static ExtentReports extentReports;
    private ExtentReportManager(){}

    public static ExtentReports getReporter(){
        if(extentReports == null){

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-reports/ExtentReport.html");

            sparkReporter.config().setReportName("OpenF1 API Automation Report");
            sparkReporter.config().setDocumentTitle("API Automation Execution Report");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("Framework", "RestAssured + TestNG");
            extentReports.setSystemInfo("Language", "Java 21");
            extentReports.setSystemInfo("Author", "Nitin Choudhary");
        }
        return extentReports;
    }

}
