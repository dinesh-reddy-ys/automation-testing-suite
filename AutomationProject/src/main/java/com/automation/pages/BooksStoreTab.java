package com.automation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.ScrollUtils;
import com.automation.utils.WebDriverUtils;

public class BooksStoreTab {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//*[@id=\"login\"]")
	private WebElement loginTab;
	@FindBy(id="userName")
	private WebElement userName;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(xpath="//*[@class='mr-2']")
	private WebElement booksTitle;
	
	
	
	public BooksStoreTab() {
		this.driver = WebDriverUtils.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		if (this.driver == null) {
			throw new IllegalStateException("Driver is not initialized before calling HomePage constructor");
		}
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginTab() {
		wait.until(ExpectedConditions.visibilityOf(loginTab));
		ScrollUtils.scrollToElement(loginTab);
		wait.until(ExpectedConditions.visibilityOf(loginTab));
		wait.until(ExpectedConditions.elementToBeClickable(loginTab));
		loginTab.click();
		
	}
	
	public void enterUserName(String user) {
		wait.until(ExpectedConditions.visibilityOf(userName));
		ScrollUtils.scrollToElement(userName);
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		
		userName.sendKeys(user);
	}
	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(password));
		ScrollUtils.scrollToElement(password);
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(pass);
	}
	public void clickOnLoginButton() {
		
		wait.until(ExpectedConditions.visibilityOf(loginTab));
		ScrollUtils.scrollToElement(loginTab);
		wait.until(ExpectedConditions.elementToBeClickable(loginTab));
		loginTab.click();
	}
	
	//Get all books titles from the Book Store using findElements
	public void getAllBooksTitle() {
		wait.until(ExpectedConditions.visibilityOf(booksTitle));
		ScrollUtils.scrollToElement(booksTitle);
		wait.until(ExpectedConditions.elementToBeClickable(booksTitle));
		//Get text of all books
		List<WebElement> books = driver.findElements(By.xpath("//div[@class='action-buttons']/preceding-sibling::div[@class='rt-tr-group']"));
		//Store the text of all books in a String array
		String[] booksTitle = new String[books.size()];
		for (int i = 0; i < books.size(); i++) {
			booksTitle[i] = books.get(i).getText();
			System.out.println(booksTitle[i]);
		}
		//Print the text of all books
		System.out.println("All books titles are: "+booksTitle);
		
		
		
	}
	
	
	
	

}
