package com.qa.Helper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Helper.utils.ElementUtil;
import com.qa.Helper.utils.FakeDataGenerator;

import io.qameta.allure.Description;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil eleutil;
	RegisterPage(WebDriver driver) {
		this.driver = driver;
		this.eleutil = new ElementUtil(driver);
	}
	By registerLink = By.linkText("Register");
	By firstname = By.id("input-firstname");
	By lastName = By.id("input-lastname");
	By inputEmail = By.id("input-email");
	By inputTelephone = By.id("input-telephone");
	By inputPassword = By.id("input-password");
	By inputConfirm = By.id("input-confirm");
	By yesRadio = By.xpath("//input[@name='newsletter' and @value ='1']");
	By noRadio = By.xpath("//input[@name='newsletter' and @value ='0']");
	By policy = By.xpath("//input[@name='agree']");
	By Submit = By.xpath("//input[@type='submit']");
	By CongratulationMessage = By.xpath("//p[contains(text(),'Congratulations!')]");
	By logout = By.linkText("Logout");
	// By againRegister = By.linkText("Continue");

	

	public void registerClick() {
		eleutil.doClick(registerLink);
	}

	@Description("Registeration description at the page level class")
	public String register(String firstname, String lastName, String inputEmail, String inputTelephone,
			String inputPassword, String inputConfirm, String tap, String tick) {
		eleutil.pageLoad();
		eleutil.doClick(registerLink);
		eleutil.doSendKeys(this.firstname, FakeDataGenerator.getFullName());
		eleutil.doSendKeys(this.lastName, lastName);
		eleutil.doSendKeys(this.inputEmail, FakeDataGenerator.getEmail());
		eleutil.doSendKeys(this.inputTelephone, inputTelephone);
		eleutil.doSendKeys(this.inputPassword, inputPassword);
		eleutil.doSendKeys(this.inputConfirm, inputConfirm);
		if (tap.equalsIgnoreCase("yes")) {
			eleutil.doSendKeys(this.yesRadio, tap);
		} else {
			eleutil.doSendKeys(this.noRadio, tap);
		}
		eleutil.doClick(policy);
		eleutil.doClick(Submit);
		String actualMessage = eleutil.getText(CongratulationMessage);
		eleutil.doClick(logout);
		eleutil.doClick(registerLink);
		return actualMessage;
	}
}
