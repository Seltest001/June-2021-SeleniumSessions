package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefException {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//stale==> not fresh, rotten
		//selenium is not able to interact if the element is not fresh
		//whenever you're performing .click(); operation, refreshing the page
		//or navigating to another page,DOM is getting changed, page is getting 
		//refreshed.OR whenever you're performing back and forward actions on the page
		//in this case also page is getting refreshed all the time.
		//How will you handle this situation?
		//Selenium says whatever the element you have created has to be updated
		//according to the page
		//why do we get stale element?==>doesn't matter both the elements are
		//available on the page,its not the element got updated, its the entire page
		//at the dom got updated and selenium will always check the fresh dom
		//To overcome this situation, we have to update the list according to latest dom
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));

		for (int i = 0; i < list.size(); i++) {
			list.get(i).click();
			list = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
		}

	}

}
