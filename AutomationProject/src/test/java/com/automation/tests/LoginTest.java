package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.BooksStoreTab;
import com.automation.pages.HomePage;
import com.automation.utils.WebDriverUtils;
import com.restapi.utils.CreateUserAndGetUserId;

public abstract class LoginTest extends BaseTest {
	
	@Test
	public void testLogin() {
		
		CreateUserAndGetUserId createUser = new CreateUserAndGetUserId();
		createUser.createUserAccount("Dinee", "Ditha@112");
		
		WebDriverUtils.getDriver().get("https://demoqa.com");
		
		HomePage homePage = new HomePage();
		homePage.scrollToBookStoreAndClick();
		
		BooksStoreTab booksTab = new BooksStoreTab();
		booksTab.clickOnLoginTab();
		booksTab.enterUserName("Dinee");
		booksTab.enterPassword("Ditha@112");
		booksTab.clickOnLoginButton();
		
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		login.clickOnLoginButton();
//		login.enterUserName("test");
//		login.enterPassword("test");
//		login.clickOnLoginButton();
		
	}

}
