package javaseleniumlearning.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".cart ul")
	List<WebElement> cartProducts;
	
	@FindBy (xpath = "(//li/button)[5]")
	WebElement checkoutButton;
	
	public List<WebElement> CartProductsEle() {
		return cartProducts;
	}
	
//	boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.findElement(By.cssSelector("h3")).getText().equals(productName));
//	Assert.assertTrue(match);
//	driver.findElement(By.xpath("(//li/button)[5]")).click();
	
	public boolean checkForProductName(String productName) {
		boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.findElement(By.cssSelector("h3")).getText().equals(productName));
		return match;

	}
	
	public CheckoutPage checkoutBtn() {
		checkoutButton.click();
		//CheckoutPage checkoutpage = new CheckoutPage(driver);
		return new CheckoutPage(driver);
	}
	

}
