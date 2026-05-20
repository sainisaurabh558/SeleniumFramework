package com.qa.Helper.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {


	FirefoxOptions fo;
	EdgeOptions eo;
	Properties prop;
	ChromeOptions co;

	OptionsManager(Properties prop) {
		this.prop = prop;
	}

	ChromeOptions getChromeOptions() {
	    co= new ChromeOptions();
	    co.addArguments("--start-maximized");
		if (Boolean.parseBoolean(prop.getProperty("headless").toLowerCase()))
		{
		co.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
		}
return co;
	}

	FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		fo.addArguments("--start-maximized");
		if (Boolean.parseBoolean(prop.getProperty("headless").toLowerCase()))
		{
			fo.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			fo.addArguments("--incognito");
		}
return fo;
	}

	EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		eo.addArguments("--start-maximized");
		if (Boolean.parseBoolean(prop.getProperty("headless").toLowerCase()))
		{
			eo.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			eo.addArguments("--incognito");
		}
return eo;
	}

}

/*	--headless=new              → Run browser in headless mode
--window-size=1920,1080    → Set browser resolution
--start-maximized          → Launch in maximized mode
--incognito                → Open in incognito/private mode
--disable-notifications    → Disable browser notifications
--disable-extensions       → Disable all extensions
--disable-infobars         → Remove “Chrome is being controlled” bar
--disable-gpu              → Disable GPU (used in headless sometimes)
--no-sandbox               → Required in some environments (CI/Docker)
--disable-dev-shm-usage    → Fix memory issues in Docker/Linux
--ignore-certificate-errors→ Ignore SSL certificate errors
--allow-running-insecure-content → Allow mixed/insecure content
--remote-allow-origins=*   → Fix ChromeDriver connection issues
--lang=en-US               → Set browser language
--user-agent=CustomAgent   → Set custom user agent
--disable-popup-blocking   → Disable popup blocking
--disable-geolocation      → Disable location access

*/

