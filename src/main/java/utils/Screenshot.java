package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

    public static String takeScreenshot(WebDriver driver) {
        String screenshotPath = "";
        try {
            // Take a screenshot of the entire page
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Get current date and time
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Specify the location where the screenshot will be saved
            screenshotPath = System.getProperty("user.dir") + "/screenshots/img_" + timestamp + ".jpg";
            File destinationFile = new File(screenshotPath);

            // Copy the screenshot to the specified location
            FileUtils.copyFile(screenshot, destinationFile);
            System.out.println("Screenshot taken and saved at: " + destinationFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("An error occurred while saving the screenshot: " + e.getMessage());
        }
        return screenshotPath;
    }
}
