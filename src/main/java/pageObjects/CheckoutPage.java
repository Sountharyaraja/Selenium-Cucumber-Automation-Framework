package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement first_Name;
	@FindBy(xpath = "//input[@id='last-name']")
	private WebElement last_Name;
	@FindBy(xpath = "//input[@id='postal-code']")
	private WebElement postal_Code;
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continue_Button;

	public String enterFirstName(String firstName) {
		first_Name.sendKeys(firstName);
		return firstName;
	}

	public String enterLastname(String lastName) {
		last_Name.sendKeys(lastName);
		return lastName;
	}

	public String enterpostalCode(String i) {
		postal_Code.sendKeys(i);
		return i;
	}

	public OverviewPage clickContinueButton() {
		continue_Button.click();
		return new OverviewPage(driver);
	}
}