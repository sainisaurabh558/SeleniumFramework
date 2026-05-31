package com.qa.Helper.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.Helper.exceptions.BrowserException;
import com.qa.Helper.exceptions.FileCustomException;

public class DriverManager {

	WebDriver driver;
	Properties prop;
	public static String highlight;
	OptionsManager options;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	/*
	 * This method is used to launch the browser fetch the browser from the property
	 * file
	 * 
	 * @return Webdriver reference.
	 * 
	 */
	public WebDriver initBrowser(Properties prop) {
		String browserName = prop.getProperty("BrowserName");
		highlight = prop.getProperty("highlight");
		options = new OptionsManager(prop);
		switch (browserName.toLowerCase().trim()) {
		case "chrome": {
			// this.driver = new ChromeDriver(options.getChromeOptions());
			tldriver.set(new ChromeDriver(options.getChromeOptions()));

			System.out.println("chrome launched");
			break;
		}
		case "firefox": {
//			this.driver = new FirefoxDriver(options.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(options.getFirefoxOptions()));
			System.out.println("firefox launched");
			break;
		}
		case "edge": {
			tldriver.set(new EdgeDriver(options.getEdgeOptions()));
			System.out.println("edge launched");
			break;
		}
		default:
			System.out.println("Incorrect browserName passed");
			throw new BrowserException("InvalidBrowser");
		}
		getDriver().manage().deleteAllCookies();
		// driver.manage().window().maximize();
		getDriver().get(prop.getProperty("Url"));

		/**
		 * this will return one local copy of driver for a specific thread
		 */
		return getDriver();
	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

	/**
	 * this method is used to initialized the property file
	 * 
	 * @returns the reference of the property file object
	 */

	// mvn test -Denv = "qa"
	public Properties initProperties() {
		prop = new Properties();
		FileInputStream fis = null;
		String envir = System.getProperty("env");
		System.out.println("selected environment"+envir);
		try {
			if (envir.equalsIgnoreCase("qa")) {
				fis = new FileInputStream("./src/test/resources/config/config.properties");
				System.out.println("selected environment"+envir);
			}
				else	if (envir.equalsIgnoreCase("dev")) {
					fis = new FileInputStream("./src/test/resources/config/config.qa.properties");
	
					System.out.println("selected environment"+envir);
			} else {
				fis = new FileInputStream("./src/test/resources/config/config.properties");
				System.out.println("selected environment"+envir);
			}
		} catch (FileNotFoundException fe) {
			System.out.println("Config file not found seems like file is not available");
			fe.printStackTrace();
			throw new FileCustomException("file seems missing");
		} catch (IOException e) {
			System.out.println("Config file not found seems like file is not available");
			e.printStackTrace();
			throw new FileCustomException("file seems missing");
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}
	void hello()
	{
		System.out.println("hello");
	}
}
