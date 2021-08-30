package testNGsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestBM {
    WebDriver driver;
    
    /*Here 3 times Browser will launch
     * 
     * -------------------
     * BeforeMethod
     *   appPageUrlTest()
     * AfterMethod     
     * ---------------------
     * BeforeMethod
     *   pageTitleTest()
     * AfterMethod
     * ----------------------  
     * BeforeMethod
     *   searchBoxTest()
     * AfterMethod 
     * -------------------------           
     *///Same result we will get here 
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Page title is : "+ title);
		Assert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		System.out.println("--------------------------------------------------");
	}
	
	@Test
	public void appPageUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("Page url: "+url);
		Assert.assertTrue(url.contains("amazon"));		
	}
	
	@Test
	public void searchBoxTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}


