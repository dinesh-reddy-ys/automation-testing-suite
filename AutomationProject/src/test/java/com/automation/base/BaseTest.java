package com.automation.base;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

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
import com.automation.utils.ExtentReportManager;
import com.automation.utils.ScreenshotUtils;
import com.automation.utils.WebDriverUtils;

public class BaseTest {
	
	// Store ExtentTest in a thread-safe way for parallel tests
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    // Store WebDriver per thread
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    // Store ExtentReports per browser (no need for static single instance now)
    private static Map<String, ExtentReports> reportMap = new HashMap<>();
    
    //Store the current browser name per thread
    private static ThreadLocal<String> currentBrowser = new ThreadLocal<>();
    
	

    
	@Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, Method method) {
    	
		// Save current browser to ThreadLocal
		currentBrowser.set(browser);
		
		
        //Initialize webDriver for this thread
        WebDriverUtils.setDriver(browser);
        
        // ✅ Confirm driver is stored
        WebDriver driverInstance = WebDriverUtils.getDriver();
        if (driverInstance == null) {
            throw new RuntimeException("WebDriver was not initialized properly.");
        }
              
        //Maximize browser window
         WebDriverUtils.getDriver().manage().window().maximize();
         
         // Initialize ExtentReports instance for the browser if not already done
         if (!reportMap.containsKey(browser)) {
             ExtentReports report = ExtentReportManager.getReporter(browser);
             reportMap.put(browser, report);
         }
         
         // Create a new ExtentTest for this test method
         ExtentTest extentTest = reportMap.get(browser).createTest(method.getName() + " [" + browser + "]");
         test.set(extentTest);
    }

    @AfterMethod
    public void teardown(ITestResult result) {
    	ExtentTest extentTest = test.get();
    	 if (result.getStatus() == ITestResult.FAILURE) {
    		 extentTest.fail("Test Failed: " + result.getThrowable());
    		 extentTest.log(Status.FAIL, "Test Failed: " + result.getThrowable());
    		 extentTest.addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot(result.getTestName()));
         } else if (result.getStatus() == ITestResult.SUCCESS) {
        	 extentTest.pass("Test Passed");
         } else if (result.getStatus() == ITestResult.SKIP) {
        	 extentTest.skip("Test Skipped");
         }
        WebDriverUtils.quitDriver();
    }
    
    @AfterSuite
    public void flushExtentReports() {
    	 for (ExtentReports report : reportMap.values()) {
             report.flush();
         }
    }
    
 // Utility method to get driver in test classes
    public WebDriver getDriver() {
        return driver.get();
    }

    // Utility method to get ExtentTest in test classes
    public ExtentTest getTest() {
        return test.get();
    }
    
    
}
