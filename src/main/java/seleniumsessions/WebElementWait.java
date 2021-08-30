package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementWait {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.manage().window().maximize();
		
		By emailId  = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		By dwnBtn =   By.xpath("//a[text()='Downloads']");
		By shpCart = By.xpath("//a[@title='Shopping Cart']");
		
		
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		WebElement email_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));				
//		email_ele.sendKeys("test@gmail.com");
		
//		waitForElementVisible(emailId, 5).sendKeys("rupa@gmail.com");
//		driver.findElement(password).sendKeys("test123");
//		driver.findElement(loginBtn).click();
		
		waitForElementVisible(shpCart,5).click();
		

	}
	
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	
		
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does notnecessarily mean that the element is visible	  
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

}
