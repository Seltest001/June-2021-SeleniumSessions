package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcepts {	
	public static void main(String []  args) {
		
		WebDriverManager.chromedriver().setup();		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	//2 types of waits are available in selenium:
	// 1.static wait:constant wait, Thread.sleep(10000)--will
	// pause the script for 10 secs.
	// 2.Dynamic wait: 10 secs, if the element is found within
	// 4 secs, rest of 6 secs will be ignored.
	//a.implicitly wait
	//b.explicitly wait--> WebDriverWait(c) -->FluentWait(c)-->Wait(I)
		
	//Implicitly wait:Dynamic wait
	//its only applicable for web elements
	//its a global wait--> applied with driver--will be applicable
	// for all upcoming webelements	
	//e1--> 5 secs to visible on the page
	//imp wait-->driver-->time out = 10 secs
	//e1-- 5 secs--> rest of the 5 secs will be ignored
	//if after 10 secs also, e1 is not visible, then selenium will throw
	//the Nosuchelement exception	
	//Implicitly Wait will be applied whenever we create driver.findElement and WebElement
	//Implicitly Wait will NOT be applied when we perform .sendKeys() and click();	
		
		
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
	
       WebElement emailId = driver.findElement(By.id("input-email"));
       WebElement password = driver.findElement(By.id("input-password"));
       WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));

       emailId.sendKeys("testing");
       password.sendKeys("testing");
       loginBtn.click();

	
	
	
	
	}
	
	
	
	

}
