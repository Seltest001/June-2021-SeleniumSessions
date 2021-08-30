package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MixingWaits {
	static WebDriver driver;

	public static void main(String[] args) {

		// implicitly wait + explicitly wait(webdriver wait OR fluentwait)
		// never use both the waits together
		//implicitly wait is a global wait and cannot be customized
		//Suppose if we have e1,e2,e3,e4,e5.....e^n webelements, implicitly wait will be
		//applied to all the elements
		//explicitly wait is a custom wait and we use explicitly to a specific
		//webelement.
		//e2-- custom wait--> webdriver wait (Exp wait)--> 10 secs

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email");
		By password = By.id("input-password");
		// By loginBtn = By.xpath("//input[@value='Login']");

		WebDriverWait wait = new WebDriverWait(driver, 10, 2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("xyz@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(password)).sendKeys("test@123");

	}

}
