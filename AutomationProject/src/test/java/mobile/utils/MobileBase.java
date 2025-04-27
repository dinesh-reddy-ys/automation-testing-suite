package mobile.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MobileBase {
    // Instance of AndroidDriver to interact with the mobile application
    private AndroidDriver driver;

    /**
     * Sets up the AndroidDriver with desired capabilities and returns the driver instance.
     * 
     * @return AndroidDriver instance
     * @throws MalformedURLException if the Appium server URL is invalid
     */
    public AndroidDriver setup() throws MalformedURLException {
        // Define desired capabilities for the mobile application
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android"); // Specify the platform as Android
        caps.setCapability("deviceName", "emulator-5554"); // Specify the device name
        caps.setCapability("app", "C:\\Users\\Cheth\\OneDrive\\Documents\\Mobile Automation\\artifact-android (1322)\\artifact-android-Signed.apk"); // Path to the app
        caps.setCapability("appPackage", "com.nov.mobilert"); // App package name
        caps.setCapability("appActivity", "crc64c15af62489e8d86f.MainActivity"); // App activity to launch

        // Initialize the AndroidDriver with the Appium server URL and capabilities
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click(); // Click on the allow button
        return driver;
    }

    /**
     * Returns the current AndroidDriver instance.
     * 
     * @return AndroidDriver instance
     */
    public AndroidDriver getDriver() {
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
