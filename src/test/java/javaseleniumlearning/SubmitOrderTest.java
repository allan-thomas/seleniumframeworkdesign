package javaseleniumlearning;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javaseleniumlearning.pageobjects.LandingPage;
import javaseleniumlearning.pageobjects.ProductCatalogue;

public class SubmitOrderTest {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/allan/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String username= "atk@mail.com";
		String password= "Atk.1881";
		String productName = "ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		landingpage.loginApplication(username, password);
		
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		  
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cart ul"));
//		WebElement cprod = cartProducts.stream().filter(cartProduct->cartProduct.findElement(By.cssSelector("h3")).getText().equals(productName)).findFirst().orElse(null);
//		System.out.println(cprod.findElement(By.cssSelector("h3")).getText());
		boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.findElement(By.cssSelector("h3")).getText().equals(productName));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("(//li/button)[5]")).click();
		Actions action = new Actions(driver);
		action.sendKeys(driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]")), "indi").build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
//		WebElement country = driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]"));
//		country.sendKeys("Indi");
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
//		int i=0;
//		while (i<2) {
//			country.sendKeys(Keys.DOWN);
//			i++;
//		}
//		country.sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector(".btnn")).click();
		String orderMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(orderMsg.equalsIgnoreCase("Thankyou for the order."));
		String orderIDarray = driver.findElement(By.cssSelector("label.ng-star-inserted")).getText().split(" ")[1];
		System.out.println(orderIDarray);
		driver.quit();
		
	}

}
