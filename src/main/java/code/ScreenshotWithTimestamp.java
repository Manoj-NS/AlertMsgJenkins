package code;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotWithTimestamp {
	

    public static void main(String[] args) {
    	
    	WebDriverManager.edgedriver().setup();
    	ChromeDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
    	
    	driver.get("https://demo.automationtesting.in/Alerts.html");

        try {
            // Interact with the necessary elements
            WebElement clickOkandcancelButton = driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));
            clickOkandcancelButton.click();

            WebElement alertmessageText = driver.findElement(By.xpath("//button[normalize-space()='click the button to display a confirm box']"));
            System.out.println(alertmessageText.isDisplayed());

            // Take a screenshot of the entire page
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Get current date and time
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Specify the location where the screenshot will be saved
            String filePath = "screenshots/img_" + timestamp + ".jpg";
            File destinationFile = new File(filePath);

            // Copy the screenshot to the specified location
            FileUtils.copyFile(screenshot, destinationFile);
            System.out.println("Screenshot taken and saved at: " + destinationFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("An error occurred while saving the screenshot: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }

}
