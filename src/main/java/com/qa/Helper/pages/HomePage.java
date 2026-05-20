package com.qa.Helper.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.Helper.utils.AppConstants;
import com.qa.Helper.utils.ElementUtil;

public class HomePage {
private	WebDriver driver;
private	ElementUtil eleUtil;

public HomePage(WebDriver driver) {
	this.driver = driver;
	this.eleUtil = new ElementUtil(driver);
}

	private final	By Heading = By.xpath("//h2[text()='My Account']");
	private final By headers = By.tagName("h2");
	private final	By searchField = By.xpath("//div[@id='search']//input[@name='search']");
	private final By searchIcon = By.xpath("//span//button[@type='button']");

	public String getHomePageTitle() {
		String actualHomePageTitle = eleUtil.waitForTitleIs("My Account", AppConstants.MEDIUM_DURATION);
		System.out.println(actualHomePageTitle);
		return actualHomePageTitle;
	}

	public boolean isLogoutLinkExist() {
		String logOutLinkText = eleUtil.getElement(Heading).getText();
		System.out.println(logOutLinkText);
		return eleUtil.getElement(Heading).isDisplayed();
	}

	public List<String> getHomePageHeaders() {
		return eleUtil.getElementTextList(headers);
	}

	public ResultsPage doSearch(String searchKey) {
		eleUtil.doClear(searchField);
		eleUtil.doSendKeys(searchField, searchKey);
		eleUtil.doClick(searchIcon);
		return new ResultsPage(driver);

	}

}
