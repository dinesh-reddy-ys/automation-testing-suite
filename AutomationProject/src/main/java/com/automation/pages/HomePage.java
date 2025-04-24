package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.utils.ScrollUtils;
import com.automation.utils.WebDriverUtils;

public class HomePage {
	private WebDriver driver;
	
	// Locators
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elements;
   
    
    
 // Constructor
    public HomePage() {
    	this.driver = WebDriverUtils.getDriver();
    	if (this.driver == null) {
            throw new IllegalStateException("Driver is not initialized before calling HomePage constructor");
        }
        
        PageFactory.initElements( driver, this);
    }
    
  //Page Actions
    public void clickOnElements() {
        elements.click();
    }
    //scroll to elements
    public void scrollToElements() {
    	ScrollUtils.scrollToElement(elements);
    	
    }

}
