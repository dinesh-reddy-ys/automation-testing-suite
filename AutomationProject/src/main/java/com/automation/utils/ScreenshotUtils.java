package com.automation.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {
	
	//Method to capture screenshot by passing a String as arguments
    public static String captureScreenshot(String testName) {
        try {
            File srcFile = ((TakesScreenshot) WebDriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
            FileUtils.copyFile(srcFile, new File(screenshotPath));
            return screenshotPath;
        } catch (Exception e) {
            System.out.println("Error while taking screenshot: " + e.getMessage());
            return null;
        }
    }

}
