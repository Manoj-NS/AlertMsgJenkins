package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AlertTypes;
import utils.ScreenshotListener;

@Listeners(ScreenshotListener.class)

public class AlertMessages extends BaseClass{
		
	@BeforeTest
	public void setData() {
		excelFileName="AlertMessages";
	}
	
	@Test(dataProvider="alertMessages")
	public void checkalertMessages(String alertMsg1, String alertMsg2) throws InterruptedException {
		
		new AlertTypes(driver)
		.alert1(alertMsg1)
		.alert2(alertMsg2);
		
	//	.assertAll();
	}
}
