package com.qa.Helper.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Helper.factory.DriverManager;

public class ElementUtil {
	WebDriver driver;
	JavaScriptUtil js;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		js = new JavaScriptUtil(driver);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void doClick(By locator) {
		getElementWithHighlight(locator).click();
	}

	public void doClear(By locator) {
		driver.findElement(locator).clear();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public Boolean getImagesVisibility(By locator) {
		Boolean flag = null;
		List<WebElement> imageList = getElements(locator);
		for (WebElement ele : imageList) {
			flag = ele.isDisplayed();
			System.out.println("image is visible:" + flag);
		}
		return flag;
	}

	public List<String> getElementTextList(By locator) {
		List<String> headerList = new ArrayList<String>();
		List<WebElement> eleList = getElements(locator);
		for (WebElement ele : eleList) {
			String header = ele.getText();
			if (header.length() != 0)
				headerList.add(header);
		}
		return headerList;
	}

	public void doSendKeys(By locator, String enteredText) {
		getElementWithHighlight(locator).sendKeys(enteredText);
	}

	public WebElement getElementWithHighlight(By locator) {

		WebElement element = getElement(locator);
		if(Boolean.parseBoolean(DriverManager.highlight))
		{
		js.flash(element);
		}
		
return element;
	}

	public String waitForTitleIs(String titleValue, long time) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		try {
			wait.until(ExpectedConditions.titleIs(titleValue));
			return driver.getTitle();
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.out.println("Failure in waiting for the title" + titleValue);
			return driver.getTitle();
		}
	}

	public String waitForPageURL(long time, String urlContainsText) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		try {
			wait.until(ExpectedConditions.urlContains(urlContainsText));
			return driver.getCurrentUrl();
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.out.println("Failure in waiting for the URL no naveen exists in the URL");
			return driver.getCurrentUrl();
		}
	}

	public WebElement waitForElementVisible(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void pageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
}
