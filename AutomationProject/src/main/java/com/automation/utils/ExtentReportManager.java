package com.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	
	
	// Returns ExtentReports instance for given browser, creates one if not present
	public static ExtentReports getReporter(String browser) {
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + browser + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Automation Report - " + browser);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
	
	
	
}
