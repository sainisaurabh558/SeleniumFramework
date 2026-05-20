package com.qa.Helper.tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Helper.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	private Map<String, String> productDetails;

	@BeforeClass
	public void homePageSetupTest() {
		homePage = loginPage.doHomePageLogin(prop.getProperty("Username"), prop.getProperty("Password"));
	}

	@Test(dataProvider = "generateDataForProductSearch")
	public void productDetailsTest(String productName, String expectedBrand) throws InterruptedException {
		productInfoPage = loginPage.navigateToProductDetails();
		productDetails = productInfoPage.productDetails(productName);
		System.out.println(productDetails);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(productDetails.get("Brand").trim(), expectedBrand, "Brand mismatch");
		softassert.assertAll();
	}
	@DataProvider
	public Object[][]generateDataForProductSearch() {
		Object[][] productList = {
		        {"macbook", "Apple"},
		        {"canon", "Canon"}
		    };

		return productList;
	}
}
