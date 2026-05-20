package com.qa.Helper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.qa.Helper.utils.AppConstants;
import com.qa.Helper.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private final By emailAddressField = By.id("input-email");
	private final By passwordField = By.id("input-password");
	private final By submit = By.xpath("//input[@type='submit']");
	private final By forgotPwdLink = By.linkText("Forgotten Password");

	public String getLoginPageTitle() {
		String actualPageTitle = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.MEDIUM_DURATION);
		System.out.println(actualPageTitle);
		return actualPageTitle;
	}

	public String getLoginPageURL() {
		String pageUrl = eleUtil.waitForPageURL(AppConstants.MEDIUM_DURATION, "naveen");
		System.out.println(pageUrl);
		return pageUrl;
	}

	public boolean isForgotPwdLinkExist() {
		Boolean forgotPasswordLinkvisibility = eleUtil.waitForElementVisible(forgotPwdLink, AppConstants.LONG_DURATION)
				.isDisplayed();
	//	System.out.println("forgot password link visibilty" + forgotPasswordLinkvisibility);
		return forgotPasswordLinkvisibility;
	}
	public HomePage doHomePageLogin(String username, String password) {
		eleUtil.doSendKeys(emailAddressField, username);
		eleUtil.doSendKeys(passwordField, password);
		eleUtil.doClick(submit);
		System.out.println("submitted clicked");
		return new HomePage(driver);
	}
	
	public ResultsPage navigateToResultPage() {
System.out.println("navigate to result page");
		return new ResultsPage(driver);
	}
	
	public ProductInfoPage navigateToProductDetails() {
		System.out.println("navigate to ProductDetails");
				return new ProductInfoPage(driver);
			}
	
	public RegisterPage navigateToRegister() {
		System.out.println("navigate to RegisterScreen");
				return new RegisterPage(driver);
			}
	
}
