package tests;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

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
import utilities.PropertyUtils;
import utilities.Report;

public class MasterTest {

	public WebDriver driver;
	public String testCaseName;
	private static ExtentReports extent;
	public static Properties inputProperties;
	public static ThreadLocal<ExtentTest> methods = new ThreadLocal<ExtentTest>();
	public static ThreadLocal <ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	@BeforeSuite
	public void doInitialSetUp(ITestContext context) {
		PropertyConfigurator.configure("log4j.properties");
		extent = ExtentManager.getInstance();
		inputProperties = PropertyUtils.readPropertyFile("./resources/global.properties");
	}

	@BeforeTest
	public void beforeTest(XmlTest test) {
		Report.info("-------" + test.getName() + "-------");
		testCaseName = test.getName();
		driver = DriverManager.getWebDriver(inputProperties.getProperty("browser"));
		DriverUtilities.openUrl(driver, inputProperties.getProperty("url"));
		ExtentTest tests = extent.createTest(testCaseName);
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
		String screenshotPath = "";
		if (result.getStatus() == ITestResult.SUCCESS) {
			methods.get().pass("Test Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			methods.get().fail(result.getThrowable());
			screenshotPath = testCaseName + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			DriverUtilities.takeScreenshot(driver, screenshotPath.replace(" ", "") + ".png");
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
