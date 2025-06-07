package javaseleniumlearning.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javaseleniumlearning.pageobjects.CartPage;
import javaseleniumlearning.pageobjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartBtn;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement myorderBtn;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement webelement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}
	
	public void waitForElementToDisappear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public CartPage goToCartPage() {
		cartBtn.click();
		return new CartPage(driver);
	}
	
	public OrderPage goToOrdersPage() {
		myorderBtn.click();
		return new OrderPage(driver);
	}
	
	
	public Actions actions() {
		Actions action = new Actions(driver);
		return action;
	}


}
