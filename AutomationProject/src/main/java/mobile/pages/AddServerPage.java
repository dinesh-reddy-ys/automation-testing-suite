package mobile.pages;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import mobile.utils.MobileDriverUtils;

public class AddServerPage {
    
	
	
	private AppiumDriver driver;
	private WebDriverWait wait;
	// Locators
	@FindBy(xpath = "(//android.widget.EditText[@index='0'])[1]")
	private WebElement newServerInput;
	@FindBy(xpath = "//android.widget.Button[@text=\"Add\"]")
	private WebElement addButton;
	@FindBy(xpath = "(//android.widget.ImageView[@index='0'])[2]")
	private WebElement editServerButton;
	@FindBy(xpath = "(//android.widget.ImageView[@index='0'])[1]")
	private WebElement backButton;
	@FindBy(xpath = "(//android.widget.EditText[@index='0'])[4]")
	private WebElement editServerInput;
	@FindBy(xpath = "//android.widget.Button[@text=\"Done\"]")
	private WebElement doneButton;
	

	// Constructor
	public AddServerPage() {

		try {
			this.driver = MobileDriverUtils.getMobileDriver();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	// Page actions
	public void enterNewServer() {
		// wait for the input to be visible
		wait.until(ExpectedConditions.visibilityOf(newServerInput));
		// Click on the server dropdown
		newServerInput.click();
		// Enter the new server name
		newServerInput.sendKeys("qa5.welldata.net");
	}

	public void clickAddButton() {
		// wait for the dropdown to be visible
		wait.until(ExpectedConditions.visibilityOf(addButton));
		// Click on the server dropdown
		addButton.click();

	}
	
	public void clickEditServerButton() {
		// wait for the dropdown to be visible
		wait.until(ExpectedConditions.visibilityOf(editServerButton));
		// Click on the server dropdown
		editServerButton.click();

	}
	public void clickBackButton() {
		// wait for the dropdown to be visible
		wait.until(ExpectedConditions.visibilityOf(backButton));
		// Click on the server dropdown
		backButton.click();

	}
	
	public void enterEditServer() {
		// wait for the input to be visible
		wait.until(ExpectedConditions.visibilityOf(editServerInput));
		// Click on the server dropdown
		editServerInput.click();
		//clear the input field
		editServerInput.clear();
		// Enter the new server name
		editServerInput.sendKeys("qa6.welldata.net");
	}
	
	public void clickDoneButton() {
		// wait for the dropdown to be visible
		wait.until(ExpectedConditions.visibilityOf(doneButton));
		// Click on the server dropdown
		doneButton.click();

	}

}
