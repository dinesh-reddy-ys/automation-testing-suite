package com.automation.base;

import java.io.File;
import java.sql.DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.automation.utils.WebDriverUtils;

public class BaseTest {
	
	public static ExtentReports extent;
    public static ExtentTest test;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	 @BeforeSuite
	    public void setupExtentReports() {
	        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
	        ExtentSparkReporter reporter = new ExtentSparkReporter(new File(reportPath));
	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	    }
    
	@Parameters("browser")
    @BeforeMethod
    public void setup( String browser) {
    	
    	
        //Open browser
        WebDriverUtils.setDriver(browser);
        
        
    	
       
        //Maximize the window
         WebDriverUtils.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void teardown(ITestResult result) {
    	 if (result.getStatus() == ITestResult.FAILURE) {
             test.fail("Test Failed: " + result.getThrowable());
             String screenshotPath = captureScreenshot(result.getName());
             test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
             test.addScreenCaptureFromPath(screenshotPath);
         } else if (result.getStatus() == ITestResult.SUCCESS) {
             test.pass("Test Passed");
         } else if (result.getStatus() == ITestResult.SKIP) {
             test.skip("Test Skipped");
         }
        WebDriverUtils.quitDriver();
    }
    
    @AfterSuite
    public void flushExtentReports() {
        extent.flush();
    }
    
    //Method to capture screenshot by passing a String as arguments
    public String captureScreenshot(String testName) {
        try {
            File srcFile = ((TakesScreenshot) WebDriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
            FileUtils.copyFile(srcFile, new File(screenshotPath));
            return screenshotPath;
        } catch (Exception e) {
            System.out.println("Error while taking screenshot: " + e.getMessage());
            return null;
        }
    }
}
