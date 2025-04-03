package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.utils.WebDriverUtils;
import com.aventstack.extentreports.Status;


public class BookListTest extends BaseTest {

	@Test
	public void getBookList() {
		test = extent.createTest("Get book list");
		WebDriverUtils.getDriver().get("https://demoqa.com");
		
		// Capture and attach screenshot
	    String screenshotPath = captureScreenshot(this.getClass().getName());
	    test.addScreenCaptureFromPath(screenshotPath);
	    
		test.log(Status.INFO, "Navigated to demoqa");
		
		HomePage home = new HomePage();
		
		home.scrollToElements();
		String screenshot = captureScreenshot("test1");
	    test.addScreenCaptureFromPath(screenshot);
		test.log(Status.INFO, "Scroll to elements");
		
		home.clickOnElements();
		String screen = captureScreenshot("test2");
	    test.addScreenCaptureFromPath(screen);
		test.log(Status.INFO, "Click on elements");	
	}

}
