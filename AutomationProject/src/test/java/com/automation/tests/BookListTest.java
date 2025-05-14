package com.automation.tests;

import org.openqa.selenium.WebDriver;
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

}
