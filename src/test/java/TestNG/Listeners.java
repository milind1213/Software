package TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        // Perform actions when a test method starts
        System.out.println("Test started: " + result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        // Perform actions when a test method succeeds
        System.out.println("Test passed: " + result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        // Perform actions when a test method is skipped
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Perform actions when a test method fails but within success percentage
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Perform actions when the test suite finishes
        System.out.println("Test suite finished");
    }

}
