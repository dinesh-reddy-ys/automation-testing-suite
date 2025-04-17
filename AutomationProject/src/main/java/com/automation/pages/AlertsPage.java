package com.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.utils.ScrollUtils;
import com.automation.utils.WebDriverUtils;

public class AlertsPage {
	WebDriver driver;
	
	// Locators
	@FindBy(xpath="//h5[text()='Alerts, Frame & Windows']")
	private WebElement alertsElement;
	
	@FindBy(xpath="//span[text()=\"Alerts\"]")
	private WebElement alerts;
	
	@FindBy(id="promtButton")
	private WebElement alertButton;
	
	// Constructor
	public AlertsPage() {
		this.driver = WebDriverUtils.getDriver();
		if (this.driver == null) {
            throw new IllegalStateException("Driver is not initialized before calling HomePage constructor");
        }
		PageFactory.initElements(driver, this);
	}
	
	// Alerts page Actions
	public void selectAlertsElements() {
		alertsElement.click();
	}
	
	public void scrollToAlertsElements() {
		ScrollUtils.scrollToElement(alertsElement);
	}
	
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
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(alert.getText());
		alert.sendKeys("hello");
		alert.dismiss();
	}
	
	
	
	
	

}
