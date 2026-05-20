package com.qa.Helper.pages;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Helper.utils.ElementUtil;

public class ProductInfoPage {
private WebDriver driver;
private ElementUtil eleUtil;
Map<String, String>  productMap= new TreeMap<String, String>();
private final By searchField = By.xpath("//div[@id='search']//input[@name='search']");
private final By searchIcon = By.xpath("//span//button[@type='button']");
private final By productNameLink=By.xpath("//div /div[@class='product-thumb']//h4/a");
private final By productDesc = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");


public ProductInfoPage(WebDriver driver)
{
	this.driver= driver;
	this.eleUtil = new ElementUtil(driver);
}

public Map<String, String> productDetails(String searchProduct) throws InterruptedException
{
	eleUtil.doClear(searchField);
	eleUtil.doSendKeys(searchField, searchProduct);
	eleUtil.doClick(searchIcon);
	eleUtil.doClick(productNameLink);
	Thread.sleep(5000);
	List<WebElement> elementTextList = eleUtil.getElements(productDesc);
	for(WebElement ele:elementTextList )
	{
	String metaData=	ele.getText();
	String[] data=metaData.split(":");
   String key1=data[0];
	String value1=data[1];
 productMap.put(key1, value1);
	}
 return productMap;
}
	
	
	
}
