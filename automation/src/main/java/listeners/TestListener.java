package listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ExtentReportManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener,IExecutionListener{
	
	private ExtentReports extent;
	private ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {

	    extent = ExtentReportManager.getReportInstance();

	    test = extent.createTest(result.getMethod().getMethodName());
	}
	
	
	public void onTestSuccess(ITestResult result) {

	    test.pass("Test passed successfully.");
	}
	

	@Override
	public void onTestFailure(ITestResult result) {

	    test.fail(result.getThrowable());

	    String screenshotPath =ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());
	            

	    try {
	        test.addScreenCaptureFromPath(screenshotPath);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void onExecutionFinish() {
		 if (extent != null) {
	    extent.flush();
	}
	}
}
