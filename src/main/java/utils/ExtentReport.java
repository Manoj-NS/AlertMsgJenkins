package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public class ExtentReport extends BaseClass {
	
	private static ExtentReports extent;
    private static ExtentSparkReporter spark;

    public static ExtentReports getExtentReports() {
    	 if (extent == null) {
             spark = new ExtentSparkReporter("./ExtentReport/result.html");
             extent = new ExtentReports();
             extent.attachReporter(spark);
             
             spark.config().setReportName("My Test Report");
             spark.config().setDocumentTitle("Automation Test Results");
             spark.config().setTheme(Theme.DARK);
         }
         return extent;
    }

}