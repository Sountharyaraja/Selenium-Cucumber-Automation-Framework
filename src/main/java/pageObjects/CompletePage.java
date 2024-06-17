package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage {
	WebDriver driver;
	CheckoutPage checkout;

	public CompletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//button[text()='Back Home']")
	private WebElement back_Home;

	public HomePage clickBackHome() {
		back_Home.click();
		return new HomePage(driver);
	}
}