package com.automation.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	
	
	// Returns ExtentReports instance for given browser, creates one if not present
	public static ExtentReports getReporter(String browser) {
       
        String reportDir = System.getProperty("user.dir") + "/reports/" + browser;
        
        String reportFile = reportDir + "/ExtentReport_" + browser + ".html";
        
        String jenkinsExpectedFile = reportDir + "/index.html";
        
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportFile);
        reporter.config().setReportName("Automation Report - " + browser);
        
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        
        //After the report is flushed (later in test teardown), copy/rename file for jenkins
        Runtime.getRuntime().addShutdownHook(new Thread(() ->{
        	try {
        		Files.copy(Paths.get(reportFile), Paths.get(jenkinsExpectedFile),StandardCopyOption.REPLACE_EXISTING);
        	} catch(IOException e){
        		
        		e.printStackTrace();
        	}
        	
        }));
        return extent;
    }
	
	
	
}
