package com.automation.utils;

import org.openqa.selenium.WebDriver;

public class WebDriverUtils {
private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	//Method to return driver
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}
	
	//Method to quit driver and remove the driver
	public static void quitDriver() {
		if(driver.get()!=null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
