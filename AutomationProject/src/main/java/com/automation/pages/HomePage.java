package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.ScrollUtils;
import com.automation.utils.WebDriverUtils;

public class HomePage {
	private WebDriver driver;
	WebDriverWait wait;

	// Locators
	@FindBy(xpath = "//h5[text()='Elements']")
	private WebElement elements;
	@FindBy(xpath = "//h5[text()=\"Book Store Application\"]")
	private WebElement bookStoreApplicationCard;

	// Constructor
	public HomePage() {
		this.driver = WebDriverUtils.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		if (this.driver == null) {
			throw new IllegalStateException("Driver is not initialized before calling HomePage constructor");
		}

		PageFactory.initElements(driver, this);
	}

	// Page Actions
	public void clickOnElements() {
		elements.click();
	}

	// scroll to elements
	public void scrollToElements() {
		ScrollUtils.scrollToElement(elements);

	}
	
	
	// Scroll to Book Store Application and click
	public void scrollToBookStoreAndClick() {
		wait.until(ExpectedConditions.visibilityOf(bookStoreApplicationCard));
		ScrollUtils.scrollToElement(bookStoreApplicationCard);
		wait.until(ExpectedConditions.elementToBeClickable(bookStoreApplicationCard));
		bookStoreApplicationCard.click();
	}

	

}
