package javaseleniumlearning.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javaseleniumlearning.TestComponents.BaseTest;
import javaseleniumlearning.pageobjects.CartPage;
import javaseleniumlearning.pageobjects.CheckoutPage;
import javaseleniumlearning.pageobjects.ConfirmationPage;
import javaseleniumlearning.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = "ErrorHandling")
	public void submitOrder() throws InterruptedException, IOException {

		String username = "atk@mail.com";
		String password = "At.1881";
		String productName = "ZARA COAT 3", country = "indi";

		ProductCatalogue productcatalogue = landingpage.loginApplication(username, password);
		Assert.assertEquals(landingpage.getErrorMessage(), "Incorrect email or password.");

	}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException {

		String username = "atk@mail.com";
		String password = "Atk.1881";
		String productName = "ZARA COAT 3", country = "indi";

		ProductCatalogue productcatalogue = landingpage.loginApplication(username, password);

		List<WebElement> products = productcatalogue.getProductList();
		CartPage cart = productcatalogue.addProductToCart(productName);

		List<WebElement> cartProducts = cart.CartProductsEle();
		boolean match = cart.checkForProductName("ZARA COAT 33");
		Assert.assertFalse(match);  

	}

}
