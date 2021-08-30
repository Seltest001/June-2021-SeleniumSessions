package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/index.html");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");		
		driver.findElement(By.linkText("CONTACTS")).click();			
		
		List<WebElement> pages = driver.findElements(By.xpath("(//div[@class='pagination']/a)[1]"));
		
		int i=0;
		while(true) {
		
		
		
		
			driver.findElement(By.xpath("//a[text()='dheeraj kumar']")).click();
		}

	}

}
