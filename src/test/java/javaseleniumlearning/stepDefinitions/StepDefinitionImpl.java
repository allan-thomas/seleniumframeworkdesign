package javaseleniumlearning.stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import javaseleniumlearning.TestComponents.BaseTest;
import javaseleniumlearning.pageobjects.LandingPage;
import javaseleniumlearning.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingpage;
	
//	Given I landed on Ecommerce Page
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingpage = launchApplication();
	}
	
//	Given Logged in with username <name> and password <password>
	@Given ("Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {
		ProductCatalogue productcatalouge = landingpage.loginApplication(username, password);
	}
}
