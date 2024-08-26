package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import base.BaseClass;

public class ScreenshotListener extends BaseClass implements ITestListener {
   
	@Override 
    public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
    }

	@Override
    public void onTestSuccess(ITestResult result) {
		 test.log(Status.PASS, "Test Case Passed: " + result.getMethod().getMethodName());
    }
    
	 @Override
	    public void onTestFailure(ITestResult result) {
	        BaseClass base = (BaseClass) result.getInstance();
	        
	        String screenshotPath = Screenshot.takeScreenshot(base.driver);

	        test.log(Status.FAIL, "Test Case Failed: " + result.getMethod().getMethodName());
	        test.log(Status.FAIL, result.getThrowable());
	        test.addScreenCaptureFromPath(screenshotPath);

	        System.out.println("Validation failed, please check the Extent Report");
	    }

	 @Override
	    public void onTestSkipped(ITestResult result) {
	        BaseClass base = (BaseClass) result.getInstance();
	        String screenshotPath = Screenshot.takeScreenshot(base.driver);

	        test.log(Status.SKIP, "Test Case Skipped: " + result.getMethod().getMethodName());
	        test.log(Status.SKIP, result.getThrowable());
	        test.addScreenCaptureFromPath(screenshotPath);

	        System.out.println("Validation failed, please check the code");
	    }
/*
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not needed for taking screenshots
    }

    @Override
    public void onStart(ITestContext context) {
        // Not needed for taking screenshots
    }

    @Override
    public void onFinish(ITestContext context) {
        // Not needed for taking screenshots
         
 }
*/    
}
