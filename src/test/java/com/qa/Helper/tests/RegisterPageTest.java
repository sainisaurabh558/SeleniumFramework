package com.qa.Helper.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Helper.base.BaseTest;
import com.qa.Helper.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Registeration page execution start")
@Story("User story for registeration")
public class RegisterPageTest extends BaseTest {

	@DataProvider
	String[][] dataGeneratorForRegistration() {
		String[][] datagen = {
				{ "saurabh5", "saini4", "saini4@gmail.com", "23444375", "test14", "test14", "no", "checked" } };
		return datagen;
	}

	/*
	 * @DataProvider Object[][] excelDataForRegisteration() { return
	 * ExcelUtil.getTestData("register"); }
	 * 
	 * @Test(dataProvider = "excelDataForRegisteration") void
	 * registrationTest(String name, String lastname, String email, String phoneno,
	 * String password, String Confirmpassword, String select, String tick) {
	 * registerPage = loginPage.navigateToRegister(); registerPage.registerClick();
	 * 
	 * String actualMessage = registerPage.register(name, lastname, email, phoneno,
	 * password, Confirmpassword, select, tick); Assert.assertEquals(actualMessage,
	 * AppConstants.CONGRATS_MESSAGE); //
	 * Assert.assertTrue(actualMessage.contains("Congratulations")); }
	 * 
	 * 
	 * 
	 */ @Test(groups = { "OnlyRegistration" }, dataProvider = "dataGeneratorForRegistration")
	@Description("Description field added for registeration method")
	@Severity(SeverityLevel.CRITICAL)
	void registrationTest(String name, String lastname, String email, String phoneno, String password,
			String Confirmpassword, String select, String tick) {
		registerPage = loginPage.navigateToRegister();

		registerPage.registerClick();

		String actualMessage = registerPage.register(name, lastname, email, phoneno, password, Confirmpassword, select,
				tick);
		Assert.assertEquals(actualMessage, AppConstants.CONGRATS_MESSAGE);
		// Assert.assertTrue(actualMessage.contains("Congratulations"));
	}
}
