package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	static WebDriver driver;
	
	public static void main(String [] args) {
		
		// 2.Dynamic wait: 10 secs, if the element is found within
		// 4 secs, rest of 6 secs will be ignored.
		//a.implicitly wait
		//b.explicitly wait--> WebDriverWait(c) -->FluentWait(c)-->Wait(I)
		//Why it is called as Explicit Wait?
		//Because it is a custom wait, not a global wait and it cannot be
		//applied to all the webelements.
	    //we can define our own wait for a specific element
		//can be applied to webelements and non webelements(alert, pop-up,title,url)-->this is
		//the major advantage
		//WebDriverWait will not have any default constructor
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("naveen@gmail.com");
        
		waitForElementPresence(emailId,10,2000).sendKeys("rupa@gmail.com");
		driver.findElement(password).sendKeys("test123");
		driver.findElement(loginBtn).click();

	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does notnecessarily mean that the element is visible
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	public static WebElement waitForElementPresence(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	
}
