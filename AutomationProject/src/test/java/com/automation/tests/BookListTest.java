package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.utils.ScreenshotUtils;
import com.automation.utils.WebDriverUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public abstract class BookListTest extends BaseTest {

	@Test
	public void getBookList() {

		
		ExtentTest log = getTest();
        WebDriverUtils.getDriver().get("https://demoqa.com");
		log.info("Navigated to website");
		HomePage homePage = new HomePage();
		homePage.scrollToBookStoreAndClick();
		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
							
	}

}
