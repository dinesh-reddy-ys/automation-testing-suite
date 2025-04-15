package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.WebDriverUtils;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(className="oxd-userdropdown-tab")
	private WebElement profileDropdown;
	
	public HomePage() {
		this.driver = WebDriverUtils.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	public void verifyElement() {
		wait.until(ExpectedConditions.visibilityOf(profileDropdown));
		profileDropdown.isDisplayed();
	}

}
