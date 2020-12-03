package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ResultListener implements ITestListener {

	public void onFinish(ITestContext Result) {

	}

	public void onStart(ITestContext Result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}


	public void onTestFailure(ITestResult Result) {
		System.out.println("Test Case Failed");
	}

	// When Test case get Skipped, this method is called.
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Test Case Skipped");
	}

	// When Test case get Started, this method is called.
	public void onTestStart(ITestResult Result) {
		System.out.println("Test Case Started Excuting");
		
	}

	// When Test case get passed, this method is called.
	public void onTestSuccess(ITestResult Result) {
		System.out.println("Test Case Passed");
	}

}
