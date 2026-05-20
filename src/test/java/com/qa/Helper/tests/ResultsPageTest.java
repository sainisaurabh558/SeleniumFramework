package com.qa.Helper.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Helper.base.BaseTest;

public class ResultsPageTest extends BaseTest {

	@BeforeClass
	public void doLogin() {
		loginPage.doHomePageLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		// used to initialized the resultspage reference.

	}

	@Test(dataProvider = "generateDataForProductSearch")
	public void itemsValidationAfterSearchTest(String productName, int count) {
		resultsPage = loginPage.navigateToResultPage();
		int itemsPresent = resultsPage.itemsValidationAfterSearch(productName);

		if (productName.equals("macbook")) {
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(itemsPresent, count);
			softAssert.assertAll();
		} else if (productName.equals("canon")) {
			Assert.assertEquals(itemsPresent, count);
		}
	}

	@DataProvider
	public Object generateDataForProductSearch() {
		Object productList[][] = { { "macbook", 3 }, { "canon", 1 } };

		return productList;
	}

}
