package mobile.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

public class LoginPage {
	
	 private AppiumDriver driver;

	    // Locators
	    private By usernameField = By.id("com.example.app:id/username");
	    private By passwordField = By.id("com.example.app:id/password");
	    private By loginButton = By.id("com.example.app:id/loginButton");
	    private By allowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");

	    // Constructor
	    public LoginPage(AppiumDriver driver) {
	        this.driver = driver;
	    }

	    // Methods to interact with the login page
	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLoginButton() {
	        driver.findElement(loginButton).click();
	    }
	    public void clickAllowButton() {
	        driver.findElement(allowButton).click();
	    }

}
