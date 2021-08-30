package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BackAndForwardSimulation {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println("----------------------------");
		
	    driver.navigate().to("https://www.amazon.in");
	    System.out.println(driver.getTitle());
	    System.out.println("------------------------------");
	    
		driver.navigate().back();
		System.out.println(driver.getTitle());
	    System.out.println("------------------------------");
	    
		driver.navigate().forward();
		System.out.println(driver.getTitle());
	    System.out.println("------------------------------");
	    
		driver.navigate().back();
		System.out.println(driver.getTitle());
	    System.out.println("------------------------------");
	    
	    driver.close();
		
	}

}
