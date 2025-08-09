package javaseleniumlearning.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javaseleniumlearning.TestComponents.BaseTest;
import javaseleniumlearning.pageobjects.CartPage;
import javaseleniumlearning.pageobjects.CheckoutPage;
import javaseleniumlearning.pageobjects.ConfirmationPage;
import javaseleniumlearning.pageobjects.LandingPage;
import javaseleniumlearning.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingpage;
	public ProductCatalogue productcatalogue;
	public CartPage cart; 
	public ConfirmationPage confirmationpage;
	
//	Given I landed on Ecommerce Page
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingpage = launchApplication();
	}
	
//	Given Logged in with username <name> and password <password>
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {
		productcatalogue = landingpage.loginApplication(username, password);
	}
	
//	When I add product <productname> from cart
	@When("^I add product (.+) from cart$")
	public void I_add_product_from_cart(String productName) {
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		
	}
	
//	And checkout <productname> and submit the order
	@When ("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
		cart = productcatalogue.goToCartPage();
		boolean match = cart.checkForProductName(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cart.checkoutBtn();
		confirmationpage = checkoutpage.cartCheckout("india");
	}
	
//	Then "Thankyou for the order." message is displayed on Confirmationpage
	@Then ("{string} message is displayed on Confirmationpage")
	public void message_is_displayed_on_Confirmationpage(String string) {
		String actualText = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(actualText.equalsIgnoreCase(string));
	}
}
