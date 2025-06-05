package javaseleniumlearning.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	String orderMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
//	Assert.assertTrue(orderMsg.equalsIgnoreCase("Thankyou for the order."));
//	String orderIDarray = driver.findElement(By.cssSelector("label.ng-star-inserted")).getText().split(" ")[1];
//	System.out.println(orderIDarray);

	@FindBy(css = ".hero-primary")
	WebElement orderMsgEle;

	@FindBy(css = "label.ng-star-inserted")
	WebElement orderIDarrayEle;

	public String getConfirmationMessage() {
		String actualText = orderMsgEle.getText();
		return actualText;
	}

	public String getorderID() {
		String orderIDArray=orderIDarrayEle.getText().split(" ")[1];
		return orderIDArray;

	}

}
