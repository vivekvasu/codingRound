package utilities;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtilities {

	/**
	 * This method is to open the URL
	 * 
	 * @param driver
	 * @param url - URL to be opened
	 * @return - True if the url is opened, else false
	 */
	public static boolean openUrl(WebDriver driver, String url) {
		Report.info("Entering method::openUrl()");
		boolean isSuccess = false;
		try {
			driver.get(url);
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to open URL");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::openUrl() with '" + isSuccess + '"');
		return isSuccess;
	}

	/**
	 * This method is to click on a webelement
	 * 
	 * @param element - Element to be clicked
	 * @return - True if the click action is success, else false
	 */
	public static boolean clickOnElement(WebElement element) {
		Report.info("Entering method::clickOnElement()");
		boolean isSuccess = false;
		try {
			element.click();
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying click on the element");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::clickOnElement() with '" + isSuccess + '"');
		return isSuccess;
	}

	/**
	 * This method is to switch to the Frame
	 * @param driver
	 * @param element
	 * @return - True/False
	 */
	public static boolean SwitchToFrame(WebDriver driver, WebElement element)
	{
		Report.info("Entering method::SwitchToFrame()");
		boolean isSuccess = false;
		try {
			driver.switchTo().frame(element);
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying switch to frame");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::SwitchToFrame() with '" + isSuccess + '"');
		return isSuccess;
	}

	/**
	 * This method is to enter a text in a webelement
	 * 
	 * @param element - textbox 
	 * @param text - Text to enter
	 * @return - the text that is entered
	 */
	public static String enterText(WebElement element, String text) {
		Report.info("Entering method::enterText()");
		String enteredText = "";
		try {
			element.sendKeys(text);
			if (element.getAttribute("value").equals(text)) {
				enteredText = text;
			}
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to enter text");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::enterText() with '" + enteredText + '"');
		return enteredText;
	}

	/**
	 * This method is to select dropdown
	 * 
	 * @param element
	 * @param dropdownValue
	 * @return true if the action is success, else false
	 */
	public static boolean selectDropdown(WebElement element, String dropdownValue) {
		Report.info("Entering method::selectDropdown()");
		boolean isSuccess = false;
		try {
			Select select = new Select(element);
			select.selectByVisibleText(dropdownValue);
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to select dropdown");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::selectDropdown() with '" + isSuccess + '"');
		return isSuccess;
	}

	/**
	 * This method is to delete all browser cookies
	 * 
	 * @param driver - WebDriver object
	 * @return - True if all the cookies are deleted, else false
	 */
	public static boolean deleteCookies(WebDriver driver) {
		Report.info("Entering method::deleteCookies()");
		boolean isSuccess = false;
		try {
			driver.manage().deleteAllCookies();
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to delete cookies");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::deleteCookies() with '" + isSuccess + '"');
		return isSuccess;
	}

	/**
	 * This method is to close the close browser
	 * 
	 * @param driver - WebDriver object
	 * @return - True if the browser is closed, else false
	 */
	public static boolean closeBrowser(WebDriver driver) {
		Report.info("Entering method::closeBrowser()");
		boolean isSuccess = false;
		try {
			driver.close();
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to close the browser");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::closeBrowser() with '" + isSuccess + '"');
		return isSuccess;
	}

	/**
	 * This method is to quit the WebDriver
	 * 
	 * @param driver - WebDriver object
	 * @return - True if the browser is closed, else false
	 */
	public static boolean quitDriver(WebDriver driver) {
		Report.info("Entering method::quitDriver()");
		boolean isSuccess = false;
		try {
			driver.quit();
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in while trying to quit browser");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::quitDriver() with '" + isSuccess + '"');
		return isSuccess;
	}

	/**
	 * This method is to get the text in a webelement
	 * 
	 * @param element - textbox 
	 * @return - the element text
	 */
	public static String getText(WebElement element) {
		Report.info("Entering method::getText()");
		String text = "";
		try {
			text = element.getText();
		} catch (Exception e) {
			Report.info("Exception occurred in retrieving text");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::getText() with '" + text + '"');
		return text;
	}

	/**
	 * This method is to wait for the webElement to become visible
	 *
	 * @param driver
	 * @param element
	 * @param seconds
	 * @return True if the element is visible, else false;
	 */
	public static boolean waitForElementToBecomeVisible(WebDriver driver, WebElement element, int seconds) {
		Report.info("Entering method::waitForElementToBecomeVisible()");
		boolean isSuccess = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in wait");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::waitForElementToBecomeVisible() with '" + isSuccess + '"');
		return isSuccess;
	}

	/**
	 * This method is to wait for the webElement to become visible
	 *
	 * @param driver
	 * @param byObject
	 * @param seconds
	 * @return True if the element is visible, else false;
	 */
	public static boolean waitForElementToBecomeVisible(WebDriver driver, By byObject, int seconds) {
		Report.info("Entering method::waitForElementToBecomeVisible()");
		boolean isSuccess = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(byObject)));
			isSuccess = true;
		} catch (Exception e) {
			Report.info("Exception occurred in wait");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::waitForElementToBecomeVisible() with '" + isSuccess + '"');
		return isSuccess;
	}

	/**
	 * This is force wait
	 * 
	 * @param durationInMilliSeconds
	 */
	public static void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	/**
	 * This method is to take screenshot
	 * 
	 * @param driver
	 * @param filePath
	 */
	public static void takeScreenshot(WebDriver driver, String filePath) {
		Report.info("Entering method::takeScreenshot() with '" + filePath + '"');
		try {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(filePath);
			FileUtils.copyFile(sourceFile, destFile);
		} catch (Exception e) {
			Report.info("Exception occurred in taking screenshot");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::takeScreenshot()");
	}
	
	/**
	 * This method is to get all the child web elements from parent element
	 * 
	 * @param driver
	 * @param byObject
	 * @return - List of elements
	 */
	public static List<WebElement> getAllWebElements(WebDriver driver, By element) {
		Report.info("Entering method::getAllWebElements()");
		List<WebElement> elementList = null;
		try {
			elementList = driver.findElements(element);
		} catch (Exception e) {
			Report.info("Exception occurred in fetching child web elements");
			Report.info("Exception : " + e.getMessage());
		}
		Report.info("Exiting method::getAllWebElements() with size " + elementList.size());
		return elementList;
	}
}
