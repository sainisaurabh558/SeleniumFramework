package com.qa.Helper.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Helper.base.BaseTest;
import com.qa.Helper.pages.HomePage;
import com.qa.Helper.utils.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test
	public void pageTitleTest() {
		Assert.assertEquals(loginPage.getLoginPageTitle(), AppConstants.LOGIN_PAGE_TITLE);
		System.out.println("Page title verified");
	}

	@Test
	public void pageURLTest() {
		Assert.assertTrue(loginPage.getLoginPageURL().contains(AppConstants.LOGIN_PAGE_URL));
		System.out.println("Page URL verified");
	}

	@Test
	public void forgotpasswordLinkVisibilityTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		System.out.println("Forgot password link available on the page");
	}

	@Test(priority = Integer.MAX_VALUE)
	public void loginTest() {
		HomePage homePage = loginPage.doHomePageLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		 Assert.assertEquals(homePage.getHomePageTitle().toLowerCase().trim(), AppConstants.HOME_PAGE_TITLE.toLowerCase().trim());
	}
}
