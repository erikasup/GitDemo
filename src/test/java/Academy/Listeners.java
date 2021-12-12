package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import recources.ExtenderReporterNG;
import recources.base;

public class Listeners extends base implements ITestListener {
	ExtentTest test;
	
	ExtentReports extent = ExtenderReporterNG.getReportObject();
	ThreadLocal <ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
	
	 test = extent.createTest(result.getMethod().getMethodName());
	 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		 // SS kai bus fail'as
		String testMethodName = result.getMethod().getMethodName(); // parodys kokiam teste yra fail'as
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
		}
		
		
		try {
			
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName()); // screenshota parodo index faile
			// * * *
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

	
}
