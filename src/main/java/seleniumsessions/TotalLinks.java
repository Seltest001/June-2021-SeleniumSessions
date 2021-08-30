package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	
	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		// ctrl+shift O to import automatically

		driver = new ChromeDriver();

		driver.get("https://www.amazon.com");

		// 1.Get the count of all the links available in the page.
		// 2.Print the text of each link (ignore the blank text)--> to achieve this
		// use if condition
		// 3.I want to print the index values also (i + text)

		//List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		By links = By.tagName("a");
		List<WebElement> linksList = getElements(links);
		
		System.out.println("Total Links: " + linksList.size());
		

//		for (int i = 0; i < linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//
//			// System.out.println(text);--> this will print all the blank values.
//
//			if (!text.isEmpty()) {
//				// System.out.println(text);
//				System.out.println(i + ": " + text);
//
//			}
//
//		}

		// for each loop:
				int i = 0;
				for (WebElement e : linksList) {
					String text = e.getText();
					if (!text.isEmpty()) {
						System.out.println(i + " :" +text);
					}
					i++;


				}
		
		driver.close();
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
