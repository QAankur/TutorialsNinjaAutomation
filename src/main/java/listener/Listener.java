package listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporting;
import utilities.TakeScreenShot;

public class Listener extends Base implements ITestListener {

	ExtentReports extent = getExtentReport();
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testname=result.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.log(Status.PASS, result.getName() + "is succeessfully passed");
		String path=TakeScreenShot.getScreenShot(testname,driver);
		System.out.print(path);
		extentTest.pass("Test is pass" + extentTest.addScreenCaptureFromPath(path));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, result.getName() + "is failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();

	}

}
