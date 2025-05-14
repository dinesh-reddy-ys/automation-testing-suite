package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.BooksStoreTab;
import com.automation.pages.HomePage;
import com.automation.utils.WebDriverUtils;
import com.restapi.utils.CreateUserAndGetUserId;

/**
 * Abstract test class for login functionality.
 * Extends the BaseTest class to inherit common test setup and teardown methods.
 */
public class LoginTest extends BaseTest {
    
    /**
     * Test method to verify the login functionality.
     * This method performs the following steps:
     * 1. Creates a user account using the REST API utility.
     * 2. Navigates to the demo website.
     * 3. Scrolls to the Book Store section and clicks on it.
     * 4. Navigates to the login tab, enters credentials, and logs in.
     */
    @Test
    public void testLogin() {
        
        // Create a new user account using the REST API utility
        //CreateUserAndGetUserId createUser = new CreateUserAndGetUserId();
       // createUser.createUserAccount("yashRaj", "Ditha@112");
        
        // Open the demo website login page
        WebDriverUtils.getDriver().get("https://demoqa.com/login");
                
        // Perform login actions on the Book Store tab
        BooksStoreTab booksTab = new BooksStoreTab();
        booksTab.enterUserName("yash");
        booksTab.enterPassword("Ditha@112");
        booksTab.clickOnLoginButton();
        
        // Pause execution for 20 seconds to observe the result (not recommended for production code)
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // Print stack trace if the thread is interrupted
            e.printStackTrace();
        }
        

    }
}
