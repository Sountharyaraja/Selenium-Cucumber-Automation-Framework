package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
	WebDriver driver;
	CheckoutPage checkout;

	public OverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='finish']")
	private WebElement finish_Button;

	public CompletePage clickFinish() {
		finish_Button.click();
		return new CompletePage(driver);
	}
}