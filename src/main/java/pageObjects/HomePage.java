package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[text()='Add to cart'])[1]")
	private WebElement add_to_cart;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']//parent::a")
	private WebElement shopping_cart;
	@FindBy(xpath = "//button[text()='Open Menu']")
	private WebElement open_menu;
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;

	public HomePage clickAddToCart() {
		add_to_cart.click();
		return new HomePage(driver);
	}

	public CartPage clickShoppingCart() {
		shopping_cart.click();
		return new CartPage(driver);
	}

	public void clickOpenMenu() {
		open_menu.click();
	}

	public LoginPage clickLogout() {
		add_to_cart.click();
		return new LoginPage(driver);
	}
}