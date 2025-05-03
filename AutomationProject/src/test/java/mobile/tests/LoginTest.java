package mobile.tests;

import org.testng.annotations.Test;

import mobile.pages.LoginPage;

import mobile.utils.MobileBase;

public class LoginTest {
	@Test
	public void testLogin() throws Exception {

		    // Create an instance of the LoginPage
    		LoginPage loginPage = new LoginPage();
    		loginPage.clickAllowButton();
    		
    		System.out.println("Server added successfully");
	}

}
