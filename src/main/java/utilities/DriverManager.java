package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sun.javafx.PlatformUtil;

public class DriverManager {

	/**
	 * This method is to get the webdriver
	 * @return - The WebDriver
	 */
	public static WebDriver getWebDriver(String browser)
	{
		WebDriver driver = null ;
		if(browser.equalsIgnoreCase("chrome"))
		{
			setDriverPath();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		return driver;
	}

	private static void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
	}
}
