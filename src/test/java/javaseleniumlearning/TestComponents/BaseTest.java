package javaseleniumlearning.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javaseleniumlearning.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	
	public LandingPage landingpage;

	public WebDriver initializeDriver() throws IOException {

		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") +"\\src\\main\\java\\javaseleniumlearning\\resources\\GlobalData.properties");
		properties.load(fis);
		String browserName = properties.getProperty("browser");

		
		if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver","C:/Users/allan/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		} else if (browserName.equals("firefox")) {
			//for firefox driver initiaztion
		
		} else if (browserName.equals("edge")) {
			//for edge driver initiaztion
		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver= initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
