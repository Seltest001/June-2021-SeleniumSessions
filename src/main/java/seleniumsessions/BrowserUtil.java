package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This utility is having different methods for different browser actions
 * This method is used to initialize the driver on the basis of the given browserName 
 */

public class BrowserUtil {

	public WebDriver driver;
	
		// browserName
	   //return: this returns WebDriver reference

	public WebDriver launchBrowser(String browserName) {

		if (browserName.equals("chrome")) {			
			//System.setProperty("webdriver.chrome.driver", "c:\\Users\\Public\\Downloads\\chromedriver.exe");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "c:\\Users\\Public\\Downloads\\geckodriver.exe");
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			System.out.println("Please pass the corrrect browser");
		}
		return driver;

	}

	public void launchUrl(String url) {
		if (url == null) {
			return;
		}
		if (url.isEmpty()) {
			return;
		}
		driver.get(url);
	}

	public String getPageTitle( ) {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageSource() {
		return driver.getPageSource();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
