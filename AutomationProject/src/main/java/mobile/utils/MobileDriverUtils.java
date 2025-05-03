package mobile.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class MobileDriverUtils {
	
	public static AppiumDriver getMobileDriver() throws MalformedURLException {
        // Define desired capabilities for the mobile application
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android"); // Specify the platform as Android
        caps.setCapability("deviceName", "emulator-5554"); // Specify the device name
        caps.setCapability("app", "C:\\Users\\Cheth\\OneDrive\\Documents\\Mobile Automation\\artifact-android (1322)\\artifact-android-Signed.apk"); // Path to the app
        caps.setCapability("appPackage", "com.nov.mobilert"); // App package name
        caps.setCapability("appActivity", "crc64c15af62489e8d86f.MainActivity"); // App activity to launch

        // Initialize the AppiumDriver with the Appium server URL and capabilities
        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);        
        return driver; // Return the driver instance
    }

}
