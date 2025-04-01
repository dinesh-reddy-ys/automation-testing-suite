package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;

public class BookListTest extends BaseTest {

	@Test
	public void getBookList() {
		
		driver.get("https://demoqa.com");//get link
		HomePage home = new HomePage(driver);
		home.scrollToElements();
		home.clickOnElements();
		
	}

}
