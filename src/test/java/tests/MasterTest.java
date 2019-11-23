package tests;

import java.io.IOException;
import java.lang.reflect.Method;
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
	public static ExtentTest methods;
	public static  ExtentTest parentTest;

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
		parentTest = extent.createTest(testCaseName);
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		Report.info("-------" + method.getName() + "-------");
		methods = parentTest.createNode(method.getName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		String screenshotPath = "";
		screenshotPath =   System.getProperty("user.dir") + "\\screenshot\\" + testCaseName + System.currentTimeMillis() + ".png";
		if (result.getStatus() == ITestResult.SUCCESS) {
			methods.pass("Test Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			methods.fail(result.getThrowable());
			DriverUtilities.takeScreenshot(driver, screenshotPath);
			try {
				methods.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			methods.skip(result.getThrowable());
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
