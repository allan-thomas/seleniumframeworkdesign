package javaseleniumlearning.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javaseleniumlearning.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));

	@FindBy(css = "#userEmail")
	WebElement username;

//	driver.findElement(By.cssSelector("#userPassword"));

	@FindBy(css = "#userPassword")
	WebElement passwordEle;

//	driver.findElement(By.cssSelector("#login"));

	@FindBy(css = "#login")
	WebElement loginbutton;
	
	@FindBy(css = ".toast-bottom-right")
	WebElement errorMessage;

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public ProductCatalogue loginApplication(String email, String password) {
		username.sendKeys(email);
		passwordEle.sendKeys(password);
		loginbutton.click();
		//ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return new ProductCatalogue(driver);
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

}
