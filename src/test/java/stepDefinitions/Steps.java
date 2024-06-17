package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.CompletePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OverviewPage;

public class Steps {
	private final WebDriver driver = new ChromeDriver();

	LoginPage login;
	HomePage home;
	CartPage cart;
	CheckoutPage checkout;
	OverviewPage overview;
	CompletePage complete;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;

	@Given("user navigates to login page by opening chrome and launch url")
	public void user_navigates_to_login_page_by_opening_chrome_and_launch() {
		configFileReader = new ConfigFileReader();
		driver.manage().window().maximize();
		pageObjectManager = new PageObjectManager(driver);
		login = pageObjectManager.getLoginPage();
		login.navigateTo_HomePage();
	}

	@When("user enters correct username and password values")
	public void user_enters_correct_username_and_password_values() {
		pageObjectManager = new PageObjectManager(driver);
		pageObjectManager.getLoginPage();
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
	}

	@Then("user is directed to the homepage")
	public void user_is_directed_to_the_homepage() {
		login.clickLogin();
	}

	@When("click to add to card")
	public void click_to_add_to_card() throws InterruptedException {
		Thread.sleep(2000);
		home = pageObjectManager.getHomePage();
		home = new HomePage(driver);
		home.clickAddToCart();
		home.clickShoppingCart();
	}

	@And("checkout the product")
	public void checkout_the_product() throws InterruptedException {
		Thread.sleep(2000);
		cart = pageObjectManager.getCartPage();
		cart = new CartPage(driver);
		cart.clickCheckout();
	}

	@When("Enter your information and click continue")
	public void enter_your_information_and_click_continue() throws InterruptedException {
		Thread.sleep(2000);
		checkout = pageObjectManager.getCheckoutPage();
		checkout = new CheckoutPage(driver);
		checkout.enterFirstName("Jai");
		checkout.enterLastname("Ram");
		checkout.enterpostalCode("57555");
		checkout.clickContinueButton();
	}

	@When("Finish the overview")
	public void finish_the_overview() throws InterruptedException {
		Thread.sleep(2000);
		overview = pageObjectManager.getOverviewPage();
		overview = new OverviewPage(driver);
		overview.clickFinish();
	}

	@When("click on back Home")
	public void click_on_back_home() throws InterruptedException {
		Thread.sleep(2000);
		complete = pageObjectManager.getCompletePage();
		complete = new CompletePage(driver);
		complete.clickBackHome();
	}

	@When("logout of the application")
	public void logout_of_the_application() throws InterruptedException {
		Thread.sleep(2000);
		home = pageObjectManager.getHomePage();
		home = new HomePage(driver);
		home.clickOpenMenu();
		home.clickLogout();
		driver.close();
	}
}