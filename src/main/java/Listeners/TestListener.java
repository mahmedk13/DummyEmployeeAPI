package Listeners;

import org.aeonbits.owner.ConfigFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utility.ConfigProperties;
import Utility.ExtentManager;
import Utility.TestSetup;
import io.restassured.RestAssured;




public class TestListener extends TestSetup implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		ExtentTest child = classLevelLogger.get().createNode(result.getMethod().getMethodName());
		testLevelLogger.set(child);
		testLevelLogger.get().log(Status.INFO, "execution of test case started "+result.getMethod().getMethodName());

		
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

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
	
	public void onTestFinish(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
		ConfigFactory.setProperty("env", "config");
		testEnvironment = ConfigFactory.create(ConfigProperties.class);
		
		RestAssured.baseURI = testEnvironment.getBaseURI();
		RestAssured.basePath = testEnvironment.getBasePath();
		
		
		extent = ExtentManager.getInstance();
		
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub

		
	}

}
