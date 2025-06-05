package javaseleniumlearning.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javaseleniumlearning.TestComponents.BaseTest;
import javaseleniumlearning.pageobjects.CartPage;
import javaseleniumlearning.pageobjects.CheckoutPage;
import javaseleniumlearning.pageobjects.ConfirmationPage;
import javaseleniumlearning.pageobjects.LandingPage;
import javaseleniumlearning.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void submitOrder() throws InterruptedException, IOException {

		String username = "atk@mail.com";
		String password = "Atk.1881";
		String productName = "ZARA COAT 3", country = "indi";

		LandingPage landingpage = launchApplication();
		landingpage.goTo();
		ProductCatalogue productcatalogue = landingpage.loginApplication(username, password);

		List<WebElement> products = productcatalogue.getProductList();
		CartPage cart = productcatalogue.addProductToCart(productName);

		List<WebElement> cartProducts = cart.CartProductsEle();
		boolean match = cart.checkForProductName(productName);
		Assert.assertTrue(match);  
		CheckoutPage checkoutpage = cart.checkoutBtn();

		ConfirmationPage confirmationpage = checkoutpage.cartCheckout(country);
		String actualText = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(actualText.equalsIgnoreCase("Thankyou for the order."));
		System.out.println(confirmationpage.getorderID());

	}

}
