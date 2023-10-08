package com.qa.testScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceDemoTest extends TestBase {

	@Parameters({ "validUserName", "validPassword" })
	@Test(priority = 1)
	public void sauceLoginPositiveTest(String validUserName, String validPassword)
			throws IOException, InterruptedException {

		WebElement userNameField = SauceOR.getUserName();
		WebElement passWordField = SauceOR.getPassword();
		WebElement loginButton = SauceOR.getLoginBtn();

		if (userNameField.isEnabled()) {
			userNameField.sendKeys(validUserName);
		} else {
			captureScreenshot(driver, "UserNameField");
			Reporter.log("UserNameField is not enabled", true);
			SAssert.assertTrue(userNameField.isEnabled());
			Thread.sleep(3000);
		}

		if (passWordField.isEnabled()) {
			passWordField.sendKeys(validPassword);
		} else {
			captureScreenshot(driver, "passWordField");
			Reporter.log("PassWordField is not enabled", true);
			SAssert.assertTrue(passWordField.isEnabled());
			Thread.sleep(3000);
		}
		if (loginButton.isDisplayed()) {
			loginButton.click();
		} else {
			captureScreenshot(driver, "loginButton");
			Reporter.log("LoginButton is not Displayed", true);
		}

		// Positive Test validations

		String ExpectedTitle = "Swag Labs";
		String ActualTitle = SauceOR.getTitleField().getText();
		if (ActualTitle.equals(ExpectedTitle)) {
			Reporter.log("Title Contains actualString", true);
			captureScreenshot(driver, "TitlevalidationPass");
			SAssert.assertEquals(ActualTitle, ExpectedTitle);
			Reporter.log("==============================================", true);
		} else {
			captureScreenshot(driver, "Titlevalidation");
			Reporter.log("Title does not match with expectedString", true);
			SAssert.assertEquals(ActualTitle, ExpectedTitle);
			Reporter.log("=============================================", true);
		}

		String ExpectedFooterText = "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		Boolean ActualFooterText = SauceOR.getFooterField().getText().contains(ExpectedFooterText);
		if (ActualFooterText) {
			Reporter.log("Page Contains ExpectedFooterText", true);
			captureScreenshot(driver, "FootervalidationPass");
			SAssert.assertTrue(ActualFooterText);
			Reporter.log("==============================================", true);
			Thread.sleep(5000);
		} else {
			captureScreenshot(driver, "Footervalidation");
			SAssert.assertTrue(ActualFooterText);
			Reporter.log("==============================================", true);
		}
		SAssert.assertAll();
	}

	@Parameters({ "InvalidUserName", "InvalidPassword" })
	@Test(priority = 2)
	public void sauceLoginNegativeTest(String InvalidUserName, String InvalidPassword)
			throws InterruptedException, IOException {

		WebElement userNameField = SauceOR.getUserName();
		WebElement passWordField = SauceOR.getPassword();
		WebElement loginButton = SauceOR.getLoginBtn();

		if (userNameField.isEnabled()) {
			userNameField.sendKeys(InvalidUserName);
		} else {
			captureScreenshot(driver, "UserNameField");
			Reporter.log("UserNameField is not enabled", true);
			SAssert.assertTrue(userNameField.isEnabled());
			Thread.sleep(3000);
		}

		if (passWordField.isEnabled()) {
			passWordField.sendKeys(InvalidPassword);
		} else {
			captureScreenshot(driver, "passWordField");
			Reporter.log("PassWordField is not enabled", true);
			SAssert.assertTrue(passWordField.isEnabled());
			Thread.sleep(3000);
		}
		if (loginButton.isDisplayed()) {
			loginButton.click();
		} else {
			captureScreenshot(driver, "loginButton");
			Reporter.log("LoginButton is not Displayed", true);
		}
		// Negative Test validations

		String ErrorExpectedText = "Epic sadface: Username and password do not match any user in this service";
		Boolean ErrorActualText = SauceOR.getInvalidTextError().getText().contains(ErrorExpectedText);

		if (ErrorActualText) {
			Reporter.log("======" + ErrorExpectedText + "======", true);
			captureScreenshot(driver, "NegativettestPass");
			SAssert.assertTrue(ErrorActualText);
			Thread.sleep(5000);

		} else {
			captureScreenshot(driver, "NegativettestFil");
			SAssert.assertTrue(ErrorActualText);

		}
		SAssert.assertAll();

	}

}
