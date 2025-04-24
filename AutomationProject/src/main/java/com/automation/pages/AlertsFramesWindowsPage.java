package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.ScrollUtils;
import com.automation.utils.WebDriverUtils;

public class AlertsFramesWindowsPage {
	WebDriver driver;
	WebDriverWait wait;
	// Alert Locators
	@FindBy(xpath="//h5[text()='Alerts, Frame & Windows']")
	private WebElement alertsElement;
    
	
	@FindBy(xpath="//span[text()=\"Alerts\"]")
	private WebElement alerts;

	@FindBy(id="promtButton")
	private WebElement alertButton;

	// Frame locators
	@FindBy(id="frame1")
	private WebElement frame1;

	@FindBy(id="frame2")
	private WebElement frame2;

	@FindBy(xpath="//span[text()='Frames']")
	private WebElement framestab;

	@FindBy(id="sampleHeading")
	private WebElement frameText;

	// Constructor
	public AlertsFramesWindowsPage() {
		this.driver = WebDriverUtils.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		if (this.driver == null) {
			throw new IllegalStateException("Driver is not initialized before calling HomePage constructor");
		}
		PageFactory.initElements(driver, this);
	}

	// Alerts page Actions
	public void selectAlertsElements() {
		alertsElement.click();
	}
    
	// Iframe Actions
	public void scrollToAlertsElements() {
		ScrollUtils.scrollToElement(alertsElement);
	}
    // Scroll to Alerts
	public void scrollToAlerts() {
		ScrollUtils.scrollToElement(alerts);
	}

	public void selectAlerts() {
		alerts.click();
	}

	public void clickAlertButton() {
		alertButton.click();
	}

	public void switchToAlert() {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("hello");
		alert.accept();
	}

	public void switchToFrame1() {
		driver.switchTo().frame(frame1);

	}

	public void switchToFrame2() {
		driver.switchTo().frame(frame2);
	}
	public void scrollToFramesTab() {
		ScrollUtils.scrollToElement(framestab);

	}
	public void clickOnFramesTab() {
		framestab.click();
	}

	public String getFrameText() {

		String text = frameText.getText();
		return text;
	}

	public void scrollToFrame2() {
		ScrollUtils.scrollToElement(frame2);
	}






}
