package javaseleniumlearning.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javaseleniumlearning.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//input[@class='input txt text-validated'])[2]")
	WebElement countryFeild;
	
	By dropdown = By.cssSelector(".ta-results");
	
	@FindBy(css  = ".ta-item:nth-of-type(2)")
	WebElement countrySelection;
	
	@FindBy(css  = ".btnn")
	WebElement placeOrderBtn;

	public ConfirmationPage cartCheckout(String country) {
//		action.sendKeys(driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]")), country).build().perform();
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
//		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	//  driver.findElement(By.cssSelector(".btnn")).click();
		
		actions().sendKeys(countryFeild, country).build().perform();
		waitForElementToAppear(dropdown);
		countrySelection.click();
		placeOrderBtn.click();
		return new ConfirmationPage(driver);
	}
}
