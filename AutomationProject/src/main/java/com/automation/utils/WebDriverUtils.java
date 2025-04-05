package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils {
private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	//Method to return driver
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	//Browser setup based on arguments
	public static void setDriver(String browser) {		
		 if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver.set(new ChromeDriver());
	        } else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver.set(new EdgeDriver());
	        }else {
	        	throw new IllegalArgumentException("Invalid browser" + browser);
	        }
	}
	
	//Method to quit driver and remove the driver
	public static void quitDriver() {
		if(driver.get()!=null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
