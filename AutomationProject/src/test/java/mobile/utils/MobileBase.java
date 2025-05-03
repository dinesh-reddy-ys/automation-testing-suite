package mobile.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class MobileBase {
    // Instance of AppiumDriver to interact with the mobile application
    private AppiumDriver driver;

    /**
     * Sets up the AndroidDriver with desired capabilities and returns the driver instance.
     * @return 
     * 
     * @return AndroidDriver instance
     * @throws MalformedURLException if the Appium server URL is invalid
     */
    

    /**
     * Returns the current AppiumDriver instance.
     * 
     * @return AppiumDriver instance
     */
    public AppiumDriver getDriver() {
        return driver;
    }

    /**
     * Quits the AndroidDriver and closes the session if it is active.
     */
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the driver session
        }
    }
}
