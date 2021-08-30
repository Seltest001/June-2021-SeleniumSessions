package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {
	static WebDriver driver;
	// use only sleep();

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email01");

		retryingElement(emailId).sendKeys("xyz@gmail.com");
		driver.close();

	}

	public static WebElement retryingElement(By locator) {
		WebElement element = null;
		int attempts = 0;
		while (attempts < 15) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("Element is not found in Attempt # " + (attempts+1));
			}
			attempts++;
		}

		return element;
	}

}
