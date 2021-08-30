package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcepts {
	
	public static void main(String [] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());		
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		
		
		///////////////////////////////////////////
		
		WebDriver driver1 = new FirefoxDriver();
		
		driver1.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
