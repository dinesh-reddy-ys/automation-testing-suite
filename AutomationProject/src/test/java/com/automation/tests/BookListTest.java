package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.BooksStoreTab;
import com.automation.pages.HomePage;
import com.automation.utils.ScreenshotUtils;
import com.automation.utils.WebDriverUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.restapi.utils.GetAllBooks;


public  class BookListTest extends BaseTest {

	@Test
	public void getBookList() {

		GetAllBooks allBooks = new GetAllBooks();
		System.out.println(allBooks.getAllBooks());
		ExtentTest log = getTest();
        WebDriverUtils.getDriver().get("https://demoqa.com/books");
		log.info("Navigated to website");
		BooksStoreTab booksTab = new BooksStoreTab();
		booksTab.getAllBooksTitle();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
							
	}
	
	@Test
	public void dragAndDrop() {
		WebDriver driver = WebDriverUtils.getDriver();
		driver.get("https://demoqa.com/droppable");
		ExtentTest log = getTest();
		log.log(Status.INFO, "Navigated to website");
//		BooksStoreTab booksTab = new BooksStoreTab();
//		booksTab.dragAndDrop();
//		ScreenshotUtils.takeScreenshot(driver, "dragAndDrop");
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		log.log(Status.INFO, "Drag and drop");
		
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
