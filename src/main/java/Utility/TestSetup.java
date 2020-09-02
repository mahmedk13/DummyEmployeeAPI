package Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class TestSetup {
	
	public static ConfigProperties testEnvironment;
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> classLevelLogger = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelLogger = new ThreadLocal<ExtentTest>();

	
	
	
	
	@BeforeSuite
	public void BeforeSuite() {
		
		
		
	}
	
	
	@BeforeClass
	public void BeforeClass() {
		
		ExtentTest parent = extent.createTest(getClass().getSimpleName());
		classLevelLogger.set(parent);
		
		
	}
	
	@BeforeMethod
	public void BeforeMethod(Method method) {
		
		
	}
	
	@AfterMethod
	public void AfterMethod() {
		extent.flush();

	}


	
}
