package testNGsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
     WebDriver driver;	
	
    @Parameters({"browser","url"})
	@BeforeTest
	public void setUp(String browserName, String url) {		
		
    	//(String browserName) is the holding parameter for browser from Parameters
    	//we can define the cross-browser concepts in the form of Parameters.
    	//This is called Paramaterization of pre-conditons with the help of
    	//@ parameters.TestNG will do mapping with the parameters
    	
    	System.out.println("browser name is: " + browserName);
		
		if(browserName.equals("chrome")) {			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}		
		else if(browserName.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		}
		else if(browserName.equals("safari")) {
			driver = new SafariDriver();
		}
		else {
			System.out.println("Please pass the right browser" + browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
