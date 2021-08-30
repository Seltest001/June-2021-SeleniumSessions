package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElement_For_Single_WebElement {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		WebElement ele = driver.findElement(By.id("input-email"));
		ele.sendKeys("xyz@gmail.com");
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		ele = driver.findElement(By.id("input-email"));
		ele.sendKeys("abc@gmail.com");
		Thread.sleep(1000);
		driver.close();
				
		
		
	}

}
