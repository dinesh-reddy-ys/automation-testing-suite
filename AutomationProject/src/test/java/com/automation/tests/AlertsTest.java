package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.AlertsFramesWindowsPage;
import com.automation.utils.WebDriverUtils;

public abstract class AlertsTest extends BaseTest {

	@Test
	public void testAlerts() {
		WebDriverUtils.getDriver().get("https://demoqa.com");
		AlertsFramesWindowsPage alerts = new AlertsFramesWindowsPage();
		alerts.scrollToAlertsElements();
		alerts.selectAlertsElements();
		alerts.scrollToAlerts();
		alerts.selectAlerts();
		alerts.clickAlertButton();
		alerts.switchToAlert();
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test()
	public void testFrames1() {
		WebDriverUtils.getDriver().get("https://demoqa.com");
		AlertsFramesWindowsPage frames = new AlertsFramesWindowsPage();
		frames.scrollToAlertsElements();
		frames.selectAlertsElements();
		frames.scrollToFramesTab();
		frames.clickOnFramesTab();
		frames.switchToFrame1();
		// frames.getFrameText();
		System.out.println(frames.getFrameText());
		Assert.assertEquals(frames.getFrameText(), "This is a sample page", "Content from iframe is not as expected");
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test

	public void testFrames2() {

		WebDriverUtils.getDriver().get("https://demoqa.com");
		AlertsFramesWindowsPage frames = new AlertsFramesWindowsPage();
		frames.scrollToAlertsElements();
		frames.selectAlertsElements();
		frames.scrollToFramesTab();
		frames.clickOnFramesTab();
		frames.scrollToFrame2();
		frames.switchToFrame2();
		System.out.println(frames.getFrameText());

	}
	
	
	
	

}
