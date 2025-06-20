package com.automation.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.BooksStoreTab;
import com.automation.pages.HomePage;
import com.automation.utils.WebDriverUtils;
import com.restapi.utils.CreateUserAndGetUserId;

/**
 * Abstract test class for login functionality. Extends the BaseTest class to
 * inherit common test setup and teardown methods.
 */
public class LoginTest extends BaseTest {

	/**
	 * Test method to verify the login functionality. This method performs the
	 * following steps: 1. Creates a user account using the REST API utility. 2.
	 * Navigates to the demo website. 3. Scrolls to the Book Store section and
	 * clicks on it. 4. Navigates to the login tab, enters credentials, and logs in.
	 */
	@Test
	public void testLogin() {

		// Create a new user account using the REST API utility
		// CreateUserAndGetUserId createUser = new CreateUserAndGetUserId();
		// createUser.createUserAccount("yashRaj", "Ditha@112");

		// Open the demo website login page
		WebDriverUtils.getDriver().get("https://demoqa.com/login");

		// Perform login actions on the Book Store tab
		BooksStoreTab booksTab = new BooksStoreTab();
		booksTab.enterUserName("yash");
		booksTab.enterPassword("Ditha@112");
		booksTab.clickOnLoginButton();

		// Pause execution for 20 seconds to observe the result (not recommended for
		// production code)
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// Print stack trace if the thread is interrupted
			e.printStackTrace();
		}

	}

	@Test
	public void getAllPrices() {
		WebDriverUtils.getDriver().get("https://www.amazon.in");
		WebDriver driver = WebDriverUtils.getDriver();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("books");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		// check if the prices are displayed
		if (prices.isEmpty()) {
			System.out.println("No prices found on the page.");
			return;
		}
		// get the prices of the books listed on the page and convert them into a
		// integer list after removing the commas

		List<Integer> priceList = new ArrayList<>();
		for (WebElement price : prices) {
			String priceText = price.getText();
			// Skip empty or null price text
			if (priceText == null || priceText.trim().isEmpty()) {
				System.out.println("Skipping empty price text.");
				continue;
			}

			// Remove commas from the price text without using built-in methods
			String cleanedPrice = "";
			for (char c : priceText.toCharArray()) {
				if (c != ',') {
					cleanedPrice += c;
				}
			}
			// Convert the cleaned price to an integer
			int priceValue = Integer.parseInt(cleanedPrice);
			System.out.println("Price: " + priceValue);
			priceList.add(priceValue);

		}

		// Print the list of prices
		System.out.println("List of Prices: " + priceList);

		// Close the driver
		driver.quit();
	}
}
