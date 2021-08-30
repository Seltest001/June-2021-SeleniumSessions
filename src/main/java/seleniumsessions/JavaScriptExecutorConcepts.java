package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcepts {
	static WebDriver driver;
	
	public static void main(String [] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		String title = jsUtil.getTitleByJS();
		System.out.println(title);
		
		//js.Util.refreshBrowserByJS();
		
//		String text = jsUtil.getPageInnerText();
//		System.out.println(text);
//		
//		if(text.contains("Customer Support")) {
//			System.out.println("PASS");
//		}
//		else {
//			System.out.println("Couldn't find the text");
//		}
//		
//		jsUtil.generateAlert("Hi this is my alert!");
//		driver.switchTo().alert().dismiss();
//		
//		WebElement ele1 = driver.findElement(By.xpath("//input[@id='input-email']"));
//		WebElement ele2 = driver.findElement(By.xpath("//input[@id='input-password']"));
//		WebElement ele3 = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
//		
//		WebElement ele4 = driver.findElement(By.xpath("//a[text() ='Desktops']"));

//		jsUtil.flash(ele1);
//		ele1.sendKeys("Rupa");
//		jsUtil.flash(ele2);
//		ele2.sendKeys("Deepa");
//		jsUtil.flash(ele3);
//		ele3.click();

		//jsUtil.clickElementByJS(ele4);
		
		jsUtil.scrollPageDown();
		Thread.sleep(5000);
		
		jsUtil.scrollPageUp();
		Thread.sleep(3000);
		
		jsUtil.scrollPageDown("500");
		Thread.sleep(3000);
		

	}

}
