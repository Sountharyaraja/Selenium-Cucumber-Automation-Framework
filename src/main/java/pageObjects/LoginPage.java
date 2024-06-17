package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import dataProviders.ConfigFileReader;

public class LoginPage {
	WebDriver driver;
	ConfigFileReader configFileReader;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader = new ConfigFileReader();
	}

	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement user_name;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement loginButton;

	public void enterUsername(String username) {
		user_name.sendKeys(username);
	}

	public void navigateTo_HomePage() {
		// value = ;
		driver.get(configFileReader.getApplicationUrl());
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public HomePage clickLogin() {
		loginButton.click();
		return new HomePage(driver);
	}

}
