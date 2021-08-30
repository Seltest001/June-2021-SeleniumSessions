package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "c:\\Users\\Public\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch browser
		
		//System.setProperty("webdriver.gecko.driver", "c:\\Users\\Public\\Downloads\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();

		// child class object is referred by parent interface reference variable->top casting
		// Top casting is used to achieve cross browser testing
		
		driver.get("https://www.google.com");
		
		//get title:
		    String title = driver.getTitle();
		    System.out.println("Page title is :  " + title);
		    System.out.println(driver.getTitle());  //Line 11 to Line 25 Automation steps.
		    
		//validation point/checkpoint/actual vs expected result
		    
		    if(title.equals ("Google")) {
		    	System.out.println("Correct title");
		    }
		    else {
		    	System.out.println("Incorrect title");
		    }
		    
		    System.out.println(driver.getCurrentUrl());
		    
		    System.out.println("________________________");
		    		    
		    String url = driver.getCurrentUrl();
		    
		    System.out.println(url);
		    
		    //Automation steps + validation point --> automation testing
		    System.out.println(driver.getPageSource().contains("Copyright The Closure Library"));
		    
		   // System.out.println(driver.getPageSource());
		    
		    // driver.close(); 
		    
		    driver.quit();
		
	}

}
