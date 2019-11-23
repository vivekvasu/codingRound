package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SignInPage;

public class SignInTest extends MasterTest {

	@Test (description = "Validate that the error is thrown when details are missing")
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		SignInPage signInPage = null;
		signInPage = new SignInPage(driver);
		signInPage.clickOnYourTripsLink();
		signInPage.clickOnSignInLink();
		signInPage.switchToSignInFrame();
		signInPage.clickOnSignInButton();
		String errors1 = signInPage.getError();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
	}
}
