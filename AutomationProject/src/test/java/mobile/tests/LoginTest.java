package mobile.tests;

import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;

import mobile.utils.MobileBase;

public class LoginTest {
	@Test
	public void testLogin() throws Exception {
		// Initialize the driver
		MobileBase mobileBase = new MobileBase();
		mobileBase.setup();

		// Create an instance of the LoginPage
		//mobile.pages.LoginPage loginPage = new mobile.pages.LoginPage(mobileBase.getDriver());

		// Perform login actions
		//loginPage.clickAllowButton();
		//loginPage.enterUsername("your_username");
		//loginPage.enterPassword("your_password");
		//loginPage.clickLoginButton();

		// Add assertions or further actions as needed

		// Close the driver
		mobileBase.tearDown();
	}

}
