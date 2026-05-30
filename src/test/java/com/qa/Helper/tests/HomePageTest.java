package com.qa.Helper.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Helper.base.BaseTest;

import io.qameta.allure.Epic;



@Epic("HomePageTest execution start")
public class HomePageTest extends BaseTest {

	@BeforeClass
	public void homePageSetup() {
//Just for ngrok autotriggering
		homePage = loginPage.doHomePageLogin(prop.getProperty("Username").trim(), prop.getProperty("Password").trim());
	}

	@Test
	public void isLogoutLinkExistTest() {
		boolean value = homePage.isLogoutLinkExist();
		System.out.println("Logout link exists:" + value);
		Assert.assertTrue(value);
	}
	@Test
	public void getHomePageHeadersTest() {
		List<String> lst = homePage.getHomePageHeaders();
		for (String text : lst) {
			System.out.println("Getting all present header:" + text);
		}
	}
	@Test(dataProvider = "productSearchLists")
	public void searchFieldTest(String productName, int num) throws InterruptedException {
		homePage.doSearch(productName);
	}
	@DataProvider
	Object[][] productSearchLists() {
		Object[][] productArray = { { "macbook", 3 }, { "imac", 1 }, { "canon", 1 }, { "samsung", 2 },
				{ "airtel", 0 } };
		return productArray;
	}
}
