package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.WebDriverUtils;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Elements
	@FindBy(name="username")
	private WebElement usernameInput;
	@FindBy(name = "password")
	private WebElement passwordInput;
	@FindBy(css=".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
	private WebElement loginbutton;
	@FindBy(css = ".oxd-icon.bi-exclamation-circle.oxd-alert-content-icon")
	private WebElement invalidCredentials;
	@FindBy(css=".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
	private WebElement requiredMessage;
    
	
	public LoginPage() {
		this.driver = WebDriverUtils.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		if(this.driver == null) {
			throw new IllegalStateException("Driver is not initialized before calling HomePage constructor");
		}
		PageFactory.initElements(driver, this);	
	}
	
	// Page action
	public void enterUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(usernameInput));		
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	public void clickLoginButton() {
		loginbutton.click();
	}
	public void invalidCredentialsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(invalidCredentials));
		invalidCredentials.isDisplayed();
	}
	public void requiredMessageDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(requiredMessage));
		requiredMessage.isDisplayed();
	}
	
}
