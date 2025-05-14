package com.orangehrm.test;

import java.time.Duration;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.utils.WebDriverUtils;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test(priority = 1)
	public void testValidLogin() {
		WebDriverUtils.getDriver().get("https://opensource-demo.orangehrmlive.com");
		LoginPage login = new LoginPage();
		login.enterUsername("admin");
		login.enterPassword("admin123");
		login.clickLoginButton();
		HomePage home = new HomePage();
		home.verifyElement();
				
	}
	
	@Test(priority = 2)
	public void testInvalidPassword() {
		WebDriverUtils.getDriver().get("https://opensource-demo.orangehrmlive.com");
		LoginPage login = new LoginPage();
		login.enterUsername("admin");
		login.enterPassword("admin124");
		login.clickLoginButton();
		login.invalidCredentialsDisplayed();
		
	}
	
	@Test(priority = 3)
	public void testInvalidUsername() {
		WebDriverUtils.getDriver().get("https://opensource-demo.orangehrmlive.com");
		LoginPage login = new LoginPage();
		login.enterUsername("admin1");
		login.enterPassword("admin123");
		login.clickLoginButton();
		login.invalidCredentialsDisplayed();
		
	}
	@Test(priority = 4)
	public void testEmptyPasswordField() {
		WebDriverUtils.getDriver().get("https://opensource-demo.orangehrmlive.com");
		LoginPage login = new LoginPage();
		login.enterUsername("admin");
		login.enterPassword("");
		login.clickLoginButton();
		login.requiredMessageDisplayed();
	}
	
	@Test(priority = 5)
	public void testEmptyUsername() {
		WebDriverUtils.getDriver().get("https://opensource-demo.orangehrmlive.com");
		LoginPage login = new LoginPage();
		login.enterUsername("");
		login.enterPassword("admin123");
		login.clickLoginButton();
		login.requiredMessageDisplayed();
		
	}
	
	@Test(priority = 6)
	public void testEmptyCredentials() {
		WebDriverUtils.getDriver().get("https://opensource-demo.orangehrmlive.com");
		LoginPage login = new LoginPage();
		login.enterUsername("");
		login.enterPassword("");
		login.clickLoginButton();
		login.requiredMessageDisplayed();
		
	}
	

}
