package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.AlertsPage;
import com.automation.utils.WebDriverUtils;

public class AlertsTest extends BaseTest{
	
	@Test
	public void testAlerts() throws InterruptedException {
		WebDriverUtils.getDriver().get("https://demoqa.com");
		AlertsPage alerts = new AlertsPage();
		alerts.scrollToAlertsElements();
		alerts.selectAlertsElements();
		alerts.scrollToAlerts();
		alerts.selectAlerts();
		alerts.clickAlertButton();
		alerts.switchToAlert();
		Thread.sleep(50000);
	}

}
