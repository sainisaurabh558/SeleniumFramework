package com.qa.Helper.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Helper.utils.ElementUtil;

public class ResultsPage {

	WebDriver driver;
	ElementUtil eleUtil;
	private final By searchField = By.xpath("//div[@id='search']//input[@name='search']");
	private final By searchIcon = By.xpath("//span//button[@type='button']");
	private final By productImage = By.xpath("//div[@class='product-thumb']/div/a/img");
	private final By productList = By
			.cssSelector("div[class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12");

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil = new ElementUtil(driver);
	}

	public int itemsValidationAfterSearch(String searchProduct) {
		eleUtil.doClear(searchField);
		eleUtil.doSendKeys(searchField, searchProduct);
		eleUtil.doClick(searchIcon);
		List<WebElement> itemsPresent=eleUtil.getElements(productList);
        eleUtil.getImagesVisibility(productImage);
        return itemsPresent.size();
	}

}
