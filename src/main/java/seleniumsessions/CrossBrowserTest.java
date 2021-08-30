package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest {
	
	static WebDriver driver;
	
	public static void main(String [] args) {
		
		String browser = "chrome";

		// cross browser testing

		if (browser.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "c:\\Users\\Public\\Downloads\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "c:\\Users\\Public\\Downloads\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		} 
		else if(browser.equals("safari")) {
			driver = new SafariDriver();
		}
		else {
			System.out.println("Please pass the corrrect browser");
		}

		driver.get("https://www.google.com");

		// get title:
		String title = driver.getTitle();
		System.out.println("Page title is :  " + title);

		// validation point/checkpoint/actual vs expected result

		if (title.equals("Google")) {
			System.out.println("Correct title");
		} else {
			System.out.println("Incorrect title");
		}

		System.out.println(driver.getCurrentUrl());

		System.out.println("________________________");

		String url = driver.getCurrentUrl();

		System.out.println(url);

		// Automation steps + validation point --> automation testing
		System.out.println(driver.getPageSource().contains("Copyright The Closure Library"));

		// System.out.println(driver.getPageSource());

		// driver.close();

		driver.quit();

	}

}
