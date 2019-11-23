package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.DriverUtilities;
import utilities.Report;

public class FlightBookingPage extends MasterPageObject {

	public FlightBookingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "OneWay")
	private WebElement oneWayRadioButton;

	@FindBy(id = "FromTag")
	private WebElement fromInputBox;

	@FindBy(id = "ToTag")
	private WebElement toInputBox;

	@FindBy(id = "SearchBtn")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@id='ui-datepicker-div']//a[contains(@class,'ui-state-default ui-state-highlight ui-state-active')]")
	private WebElement date;

	@FindBy(xpath = "//ul[@id='ui-id-1']//li")
	private WebElement fromSuggestion;

	@FindBy(xpath = "//ul[@id='ui-id-2']//li")
	private WebElement toSuggestion;

	private By searchSummary = By.className("searchSummary");
	
	private By fromSuggestionList = By.xpath("//ul[@id='ui-id-1']//li");

	private By toSuggestionList = By.xpath("//ul[@id='ui-id-2']//li");

	/**
	 * This method is to click on One Way 
	 * 
	 * @return True if the click is success, else false
	 */
	public boolean clickOneWayRadioButton()
	{
		Report.info("Entering method::clickOneWayRadioButton()");
		boolean isClicked = false;
		isClicked = DriverUtilities.clickOnElement(oneWayRadioButton);
		Report.info("Exiting method::clickOneWayRadioButton() with '" + isClicked + '"');
		return isClicked;
	}

	/**
	 * This method is to enter the From location
	 * 
	 * @return - the entered text
	 */
	public String enterFromLocation(String from)
	{
		Report.info("Entering method::enterFromLocation()");
		String enteredText = "";
		fromInputBox.clear();
		enteredText = DriverUtilities.enterText(fromInputBox, from);
		Report.info("Exiting method::enterFromLocation() with '" + enteredText + '"');
		return enteredText;
	}


	/**
	 * This method is to enter the To location
	 * 
	 * @return - the entered text
	 */
	public String enterToLocation(String to)
	{
		Report.info("Entering method::enterToLocation()");
		String enteredText = "";
		toInputBox.clear();
		enteredText = DriverUtilities.enterText(toInputBox, to);
		Report.info("Exiting method::enterToLocation() with '" + enteredText + '"');
		return enteredText;
	}

	/**
	 * This method is to check whether the SearchSummaryDisplayed
	 * 
	 * @return - True/False
	 */
	public boolean isSearchSummaryDisplayed()
	{
		Report.info("Entering method::isSearchSummaryDisplayed()");
		boolean isDisplayed = false;
		isDisplayed = DriverUtilities.waitForElementToBecomeVisible(driver, searchSummary, 5);
		Report.info("Exiting method::isSearchSummaryDisplayed() with '" + isDisplayed + '"');
		return isDisplayed;
	}

	/**
	 * This method is to click on Search button
	 * 
	 * @return True if the click is success, else false
	 */
	public boolean clickOnSearchButton()
	{
		Report.info("Entering method::clickOnSearchButton()");
		boolean isClicked = false;
		isClicked = DriverUtilities.clickOnElement(searchButton);
		Report.info("Exiting method::clickOnSearchButton() with '" + isClicked + '"');
		return isClicked;
	}

	/**
	 * This method is to click on active date
	 * 
	 * @return True if the click is success, else false
	 */
	public boolean clickOnActiveDate()
	{
		Report.info("Entering method::clickOnActiveDate()");
		boolean isClicked = false;
		isClicked = DriverUtilities.clickOnElement(date);
		Report.info("Exiting method::clickOnActiveDate() with '" + isClicked + '"');
		return isClicked;
	}

	/**
	 * This method is to wait for the from suggestion list box
	 * @return - True/False
	 */
	public boolean isFromSuggestionBoxLoaded()
	{
		Report.info("Entering method::isFromSuggestionBoxLoaded()");
		boolean isDisplayed = false;
		isDisplayed = DriverUtilities.waitForElementToBecomeVisible(driver, fromSuggestion, 5);
		Report.info("Exiting method::isFromSuggestionBoxLoaded() with '" + isDisplayed + '"');
		return isDisplayed;
	}

	/**
	 * This method is to wait for the to suggestion list box
	 * @return - True/False
	 */
	public boolean isToSuggestionBoxLoaded()
	{
		Report.info("Entering method::isToSuggestionBoxLoaded()");
		boolean isDisplayed = false;
		isDisplayed = DriverUtilities.waitForElementToBecomeVisible(driver, toSuggestion, 5);
		Report.info("Exiting method::isToSuggestionBoxLoaded() with '" + isDisplayed + '"');
		return isDisplayed;
	}

	/**
	 * This method is to fetch all the elements from 'From' dropdown
	 * @return - List of suggestions
	 */
	public List<WebElement> getSuggestionListFromOriginDropdown()
	{
		Report.info("Entering method::getSuggestionListFromOriginDropdown()");
		List<WebElement> elements = null;
		elements = DriverUtilities.getAllWebElements(driver, fromSuggestionList);
		Report.info("Exiting method::getSuggestionListFromOriginDropdown() with size '" + elements.size() + '"');
		return elements;
	}

	/**
	 * This method is to fetch all the elements from 'To' dropdown
	 * @return - List of suggestions
	 */
	public List<WebElement> getSuggestionListfromDestinationDropdown()
	{
		Report.info("Entering method::getSuggestionListfromDestinationDropdown()");
		List<WebElement> elements = null;
		elements = DriverUtilities.getAllWebElements(driver, toSuggestionList);
		Report.info("Exiting method::getSuggestionListfromDestinationDropdown() with size '" + elements.size() + '"');
		return elements;
	}
}
