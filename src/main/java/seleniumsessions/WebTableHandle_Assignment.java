package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle_Assignment {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		
		By xpath = By.xpath("//td//preceding-sibling::a[text()='Ali-ceyhun@gmail.com']//parent::td//preceding-sibling::td");
		 List<WebElement> eleList = contactDetails(xpath);
         
		 
			for (int i=0; i<eleList.size(); i++) {
				String text = eleList.get(i).getText();
				System.out.println(text);
			}
			
			driver.close();

		}

		public static List<WebElement> contactDetails(By locator) {
			return driver.findElements(locator);
		}

	}
