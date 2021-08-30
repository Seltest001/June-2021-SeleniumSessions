package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseSessionsId {
	
	public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver","c:\\Users\\Public\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch browser
		
		driver.get("https://www.google.com");
		
		//get title:
		
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);
		
		//validation point/checkpoint/actual vs expected result
		
		if(title.equals ("Google")) {
			System.out.println("Correct title");
		}
		else {
			System.out.println("Incorrect title");
		}
		
		//System.out.println(driver.getCurrentUrl());
		
				
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		//driver.quit();
		driver.close();
		
		
		//re-open the browser:
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}

}
