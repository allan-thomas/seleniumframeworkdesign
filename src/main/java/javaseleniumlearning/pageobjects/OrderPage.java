package javaseleniumlearning.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javaseleniumlearning.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	@FindBy (xpath  = "//td[2]")
	List<WebElement> cartProductnames;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkForProductName(String productName) {
		//waitForWebElementToAppear(cartProductnames);
		boolean match = cartProductnames.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
		return match;

	}

}
