package com.qa.Helper.base;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.Helper.factory.DriverManager;
import com.qa.Helper.listeners.TestAllureListener;
import com.qa.Helper.pages.HomePage;
import com.qa.Helper.pages.LoginPage;
import com.qa.Helper.pages.ProductInfoPage;
import com.qa.Helper.pages.RegisterPage;
import com.qa.Helper.pages.ResultsPage;


//@Listeners({ChainTestListener.class, TestAllureListener.class})
public class BaseTest {
	protected Properties prop;
	DriverManager df;
	protected WebDriver driver;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected ProductInfoPage productInfoPage;
	protected ResultsPage resultsPage;
	protected RegisterPage registerPage;

	@Parameters({ "browser" })
	@BeforeTest
	public void SetUp(@Optional("Chrome") String parabrowserName) throws IOException {
		df = new DriverManager();
		prop = df.initProperties();
		System.out.println("Param browser: " + parabrowserName);

		if (parabrowserName != null) {
			prop.setProperty("BrowserName", parabrowserName);
		}
		System.out.println("Prop browser before override: " + prop.getProperty("BrowserName"));
		driver = df.initBrowser(prop);

		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void TearDown() throws InterruptedException {
		driver.quit();
	}

}
