package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTraverse {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		/*   //td[text()='Alfreds Futterkiste']
		 * (//table[@id="customers"]/tbody/tr/td)[1]
		 * (//table[@id="customers"]/tbody/tr/td)[4]
		 * (//table[@id="customers"]/tbody/tr/td)[7]
		 * (//table[@id="customers"]/tbody/tr/td)[10]
		 * (//table[@id="customers"]/tbody/tr/td)[13]
		 * (//table[@id="customers"]/tbody/tr/td)[16]
		 */
		  
		  
		  
		 
		 
	
	
	
	}

}
