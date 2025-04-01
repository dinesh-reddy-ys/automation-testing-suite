package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.utils.ScrollUtils;

public class HomePage {
	private WebDriver driver;
	
	// Locators
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elements;
   
    
    
 // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
  //Page Actions
    public void clickOnElements() {
        elements.click();
    }
    //scroll to elements
    public void scrollToElements() {
    	ScrollUtils.scrollToElement(driver, elements);
    	
    }

}
