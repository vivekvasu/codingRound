package tests;

import java.lang.reflect.Method;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.DriverManager;
import utilities.DriverUtilities;
import utilities.ExtentManager;
import utilities.Report;

public class MasterTest {

	public WebDriver driver;
	private static ExtentReports extent;
	public static ThreadLocal<ExtentTest> methods = new ThreadLocal<ExtentTest>();
	public static ThreadLocal <ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	@BeforeSuite
	public void doInitialSetUp(ITestContext context) {
		PropertyConfigurator.configure("log4j.properties");
		extent = ExtentManager.getInstance();
	}

	@BeforeTest
	public void beforeTest(XmlTest method) {
		Report.info("-------" + method.getName() + "-------");
		driver = DriverManager.getWebDriver();
		ExtentTest tests = extent.createTest(method.getName());
		parentTest.set(tests);
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		Report.info("-------" + method.getName() + "-------");
		ExtentTest testmethod = parentTest.get().createNode(method.getName());
		methods.set(testmethod);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			methods.get().pass("Test Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			methods.get().fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			methods.get().skip(result.getThrowable());
		}

	}

	@AfterTest
	public void afterTest(XmlTest method) {
		DriverUtilities.deleteCookies(driver);
		DriverUtilities.closeBrowser(driver);
		if(driver != null)
		{
			DriverUtilities.quitDriver(driver);
		}
	}


	@AfterSuite
	public void quitBrowser() {
		extent.flush();
	}
}
