package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;

    @BeforeMethod
    public void setup() {
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");  // Prevents security issues in CI/CD
        options.addArguments("--disable-dev-shm-usage");  // Fixes shared memory issues
        options.addArguments("--headless=new");  // Runs Chrome without GUI in GitHub Actions
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        
        //options.addArguments("--user-data-dir=/tmp/chrome-user-data" + System.currentTimeMillis());  // Unique user data directory
    	   	
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
        	
            driver.quit();
        }
    }
}
