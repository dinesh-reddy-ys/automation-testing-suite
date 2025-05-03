package mobile.pages;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import mobile.utils.MobileDriverUtils;

public class LoginPage {
	
	 private AppiumDriver driver;
	 private WebDriverWait wait;

	    // Locators
	    @FindBy(id = "com.example.app:id/username")
	    private WebElement usernameElement;
	    @FindBy(id = "com.example.app:id/password")
	    private WebElement passwordElement;
	    @FindBy(id = "com.example.app:id/loginButton")
	    private WebElement loginButtonElement;
	    @FindBy(xpath = "//android.widget.EditText[@text=\"welldata.net\"]")
	    private WebElement serverDropdown;
	    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Add New +\"]")
	    private WebElement addNewServer;
	    @FindBy(xpath = "//android.widget.Switch")
	    private WebElement rememberMeButton;
	    
	    // Constructor
	    public LoginPage() {
	    	
	        try {
				this.driver = MobileDriverUtils.getMobileDriver();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        PageFactory.initElements(driver, this);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    }

	    // Methods to interact with the login page
	    public void clickServerDropdown() {
	    	//wait for the dropdown to be visible
	        wait.until(ExpectedConditions.visibilityOf(serverDropdown));
	    	// Click on the server dropdown
	        serverDropdown.click();
	        
	    }
	    
	    public void clickAddNewServer() {
	    	//wait for the dropdown to be visible
	        wait.until(ExpectedConditions.visibilityOf(addNewServer));
	    	// Click on the server dropdown
	        addNewServer.click();
	        
	    }
	    
	    
	    public void enterUsername(String username) {
	        usernameElement.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        passwordElement.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        loginButtonElement.click();
	    }
	    public void clickAllowButton() {
	        	    	//wait for the allow button to be visible
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	// Click on the allow button
	        WebElement allowButton = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
	        allowButton.click();
	    }
	    
	    // Verify remember me button is checked
	    public boolean isRememberMeChecked() {
	    	//wait for the remember me button to be visible
	        wait.until(ExpectedConditions.visibilityOf(rememberMeButton));
	    	// Click on the server dropdown
	    	return rememberMeButton.isSelected();
	    }
	    
	    // Verify remember me button is not checked
	    public boolean isRememberMeNotChecked() {
	    	//wait for the remember me button to be visible
	        wait.until(ExpectedConditions.visibilityOf(rememberMeButton));
	    	// Click on the server dropdown
	    	return !rememberMeButton.isSelected();
	    }
	    
	    // Enable remember me button
	    public void enableRememberMe() {
	    	//wait for the remember me button to be visible
	        wait.until(ExpectedConditions.visibilityOf(rememberMeButton));
	    	// Click on the server dropdown
	    	if(!rememberMeButton.isSelected()) {
	    		rememberMeButton.click();
	    	}
	    }
	    // Disable remember me button
	    public void disableRememberMe() {
	    	//wait for the remember me button to be visible
	        wait.until(ExpectedConditions.visibilityOf(rememberMeButton));
	    	// Click on the server dropdown
	    	if(rememberMeButton.isSelected()) {
	    		rememberMeButton.click();
	    	}
	    }
	    

}
