package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationConcept {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		//get() method and navigate().to method==>They both are same, internally both are calling get(); method, 
		//but their syntax are different.
		
		/*
		 * Four(4) navigate() methods: 1. navigate().to 2. navigate().back 3.
		 * navigate().forward 4. navigate().refresh
		 */

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com");

		driver.navigate().to("https://www.amazon.com");

		// driver.get("https://www.amazon.com");

		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.close();

	}

}


