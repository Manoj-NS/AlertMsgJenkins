package code;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertMsgPopup {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.automationtesting.in/Alerts.html");
	
		WebElement alertMsg1=driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]"));
		alertMsg1.click();
		
		 // Switch to the alert
		Alert alert = driver.switchTo().alert();
		
        // Get the text of the alert
        String actualalertMsg1 = alert.getText();
        String expectedalertMsg1="I am an alert box!";
        
        Assert.assertEquals(actualalertMsg1, expectedalertMsg1, "Alertmsg1 validation failed");
        System.out.println("Alertmsg1 validation passed");

        // To click ok button
        alert.accept();
        
        
        WebElement alertButton2 = driver.findElement(By.xpath("//a[contains(text(), 'Alert with OK & Cancel')]"));
        alertButton2.click();
        
        WebElement alertmsg2 = driver.findElement(By.xpath("//button[contains(text(), 'click the button to display a confirm box ')]"));
        String Actualalertmsg2=alertmsg2.getText();
        String Expectedalertmsg2="click the button to display a confirm box";
        
        Assert.assertEquals(Actualalertmsg2, Expectedalertmsg2, "Alertmsg2 Validation Failed");
        System.out.println("Alertmsg2 Validation Passed");
        
        Assert.assertTrue(alertmsg2.isDisplayed(), "Alertmsg2 not displayed");
       
        alertmsg2.click();
        alert.dismiss(); 
        
        WebElement alertButton3 = driver.findElement(By.xpath("//a[contains(text(), 'Alert with Textbox ')]"));
        alertButton3.click();
        
        WebElement alertMsg3 = driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        String actualAlertMsg3=alertMsg3.getText();
        String expectedAlertMsg3="click the button to demonstrate the prompt box";
       
        Assert.assertEquals(actualAlertMsg3, expectedAlertMsg3, "AlertMsg3 validation failed");
        System.out.println("alertMsg3 validation passed");
        
        alertMsg3.click();
        
        alert.sendKeys("Test message, please ignore it");
        
        alert.accept();
        
        
       
 //       driver.quit();
	}
	

}
