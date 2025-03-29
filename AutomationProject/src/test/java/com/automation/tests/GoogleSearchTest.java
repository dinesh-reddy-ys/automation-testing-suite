package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends com.automation.base.BaseTest {
	@Test
    public void searchTest() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("TestNG Automation");
        searchBox.submit();

        //Assert.assertTrue(driver.getTitle().contains("TestNG Automation"), "Title does not match!");
    }

}
