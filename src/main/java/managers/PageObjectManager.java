package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.CompletePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OverviewPage;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private CartPage cart;
	private CheckoutPage checkout;
	private OverviewPage overview;
	private CompletePage complete;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (home == null) ? home = new HomePage(driver) : home;
	}

	public LoginPage getLoginPage() {
		return (login == null) ? login = new LoginPage(driver) : login;
	}

	public CartPage getCartPage() {
		return (cart == null) ? cart = new CartPage(driver) : cart;
	}

	public CheckoutPage getCheckoutPage() {
		return (checkout == null) ? checkout = new CheckoutPage(driver) : checkout;
	}

	public OverviewPage getOverviewPage() {
		return (overview == null) ? overview = new OverviewPage(driver) : overview;
	}

	public CompletePage getCompletePage() {
		return (complete == null) ? complete = new CompletePage(driver) : complete;
	}

}
