package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.DriverUtilities;
import utilities.Report;

public class SignInPage extends MasterPageObject {

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Your trips")
	private WebElement yourTrips;

	@FindBy(id = "SignIn")
	private WebElement signInLink;

	@FindBy(id = "signInButton")
	private WebElement signInButton;

	@FindBy(id = "errors1")
	private WebElement error;

	@FindBy(id = "modal_window")
	private WebElement signInFrame;

	/**
	 * This method is to click on Your Trips link
	 * 
	 * @return True if the click is success, else false
	 */
	public boolean clickOnYourTripsLink()
	{
		Report.info("Entering method::clickOnYourTripsLink()");
		boolean isClicked = false;
		isClicked = DriverUtilities.clickOnElement(yourTrips);
		Report.info("Exiting method::clickOnYourTripsLink() with '" + isClicked + '"');
		return isClicked;
	}

	/**
	 * This method is to click on Sign In link
	 * 
	 * @return True if the click is success, else false
	 */
	public boolean clickOnSignInLink()
	{
		Report.info("Entering method::clickOnSignInLink()");
		boolean isClicked = false;
		isClicked = DriverUtilities.clickOnElement(signInLink);
		Report.info("Exiting method::clickOnSignInLink() with '" + isClicked + '"');
		return isClicked;
	}

	/**
	 * This method is to switch to Sign In frame
	 * 
	 * @return True if switched, else false
	 */
	public boolean switchToSignInFrame()
	{
		Report.info("Entering method::switchToSignInFrame()");
		boolean isSuccess = false;
		isSuccess = DriverUtilities.SwitchToFrame(driver, signInFrame);
		Report.info("Exiting method::switchToSignInFrame() with '" + isSuccess + '"');
		return isSuccess;
	}

	/**
	 * This method is to click on Sign In button
	 * 
	 * @return True if the click is success, else false
	 */
	public boolean clickOnSignInButton()
	{
		Report.info("Entering method::clickOnSignInButton()");
		boolean isClicked = false;
		DriverUtilities.waitForElementToBecomeVisible(driver, signInButton, 3);
		isClicked = DriverUtilities.clickOnElement(signInButton);
		Report.info("Exiting method::clickOnSignInButton() with '" + isClicked + '"');
		return isClicked;
	}

	/**
	 * This method is to get the error message
	 * 
	 * @return - the text
	 */
	public String getError()
	{
		Report.info("Entering method::getError()");
		String text = "";
		DriverUtilities.waitForElementToBecomeVisible(driver, error, 3);
		text = DriverUtilities.getText(error);
		Report.info("Exiting method::getError() with '" + text + '"');
		return text;
	}
}
