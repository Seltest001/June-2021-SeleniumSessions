package seleniumsessions;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverCombination {
	public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver","c:\\Users\\Public\\Downloads\\chromedriver.exe");		
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

}
