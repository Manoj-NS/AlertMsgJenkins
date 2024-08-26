package base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReport;
import utils.ReadExcel;

public class BaseClass {
	
	public RemoteWebDriver driver;
	public String excelFileName;
	protected static ExtentReports extent;
    protected static ExtentTest test;
	
	@BeforeSuite
	public void startReport() {
		extent = ExtentReport.getExtentReports();
		
	}
	
	@BeforeClass
	public void testcaseDetails() {
		
	}
	
	@DataProvider
	public String[][] alertMessages() throws IOException{
	
		return ReadExcel.getData(excelFileName);
	}
	
	@Parameters ({"browserName","URL"})
	@BeforeMethod
	public void browserSetup(String browserName, String url) {
		
		if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			}else {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

		
	}
	
				
	public void afterMethod() {
		driver.close();
	}
	
	 @AfterClass
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
	@AfterSuite
	public void stopReport() {
		
		 if (extent != null) {
	            extent.flush();
	        }
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
