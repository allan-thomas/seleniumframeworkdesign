package javaseleniumlearning.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstactComponent {
	
	WebDriver driver;
	
	public AbstactComponent(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartBtn;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void clickCart() {
		cartBtn.click();
	}


}
