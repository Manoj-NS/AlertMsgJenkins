package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.BaseClass;


public class AlertTypes extends BaseClass {
		
	public AlertTypes (RemoteWebDriver commonDriver) {
		this.driver=commonDriver;
			}
	
	public AlertTypes alert1(String alertMsg1) throws InterruptedException {
		
		 WebElement clickOkandcancelButton = driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));
         clickOkandcancelButton.click();         
         Thread.sleep(5000);         
         WebElement alertmessageText = driver.findElement(By.xpath("//button[normalize-space()='click the button to display a confirm box']"));
         String actualAlert1=alertmessageText.getText();
         String expectedAlert1=alertMsg1;

         Assert.assertEquals(actualAlert1, expectedAlert1, "Alert1 validation failed");
         System.out.println("Alert1 validation passed");
     		
		return this;
	}

	public AlertTypes alert2 (String alertMsg2) {
		
		WebElement alertwithtextButton = driver.findElement(By.xpath("(//a[@class='analystic'])[3]"));	
		alertwithtextButton.click();
		System.out.println("Button2 clicked");
				
		
		WebElement alertmessageText2 = driver.findElement(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
		String actualAlert2=alertmessageText2.getText();
		String expectedAlert2=alertMsg2;
		
		Assert.assertEquals(actualAlert2, expectedAlert2, "Alert2 validation failed "+"\n");
		System.out.println("Alert2 validation passed");
		
		return this;
	}
	
	/*
	 * public void assertAll() { softAssert.assertAll(); }
	 */
}
