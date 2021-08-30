package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcepts {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
//		driver.get("https://demo.opencart.com/index.php?route=account/login");
	    
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
//		driver.findElement(By.name("proceed")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
//		String text = getAlertText(5);		
//    	System.out.println(text);
		
//		System.out.println(alert.getText());
//		Thread.sleep(5000);
//		alert.accept();		
		
		//titles:
		
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		if (wait.until(ExpectedConditions.titleContains ("Login"))) {
//			System.out.println(driver.getTitle());
//		}		
		
//		String title = waitForTitle("Login", 5);		
//		System.out.println(title);
//		driver.close();		
		
				
//		driver.findElement(By.linkText("Register")).click();
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		if(wait.until(ExpectedConditions.urlContains("/register"))) {
//			System.out.println(driver.getCurrentUrl());
//		}
		
		driver.findElement(By.linkText("Register")).click();
		
		String url = waitForUrlContains("/register", 5);
		System.out.println(url);
		//driver.close();
		
	}
	
	
	public static String waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait (driver, timeOut);
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();			
		}
		return null;
		
	}
	
	public static String waitForFullUrl(String urlValue, int timeOut) {
	     WebDriverWait wait = new WebDriverWait(driver,timeOut);
	     if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
	    	 return driver.getCurrentUrl();
	     }
	     return null;
	}
	
	public static String waitForTitleContains(String titleValue, int timeOut)	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleContains(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}	
	
	public static String waitForTitleIs(String fullTitle, int timeOut)	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleContains(fullTitle))) {
			return driver.getTitle();
		}
		return null;
	}	
	
		
	public static String waitForTitle(String titleValue, int timeOut)	{
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleContains(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}	
	
	
	public static Alert waitForAlert(int timeOut) {		
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());		
	}
	
	public static String getAlertText(int timeOut) {		
		//return waitForAlert(timeOut).getText();
		String text = waitForAlert(timeOut).getText();
		acceptAlert(timeOut);
		return text;
	}
	
	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public static void sendKeysOnAlert(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
	}

}
