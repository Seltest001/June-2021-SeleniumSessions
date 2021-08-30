package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {
	static WebDriver driver;
	
	public static void main (String[] args) {
		
		//selenium doesn't give any webtable-in built methods.
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.espncricinfo.com/series/india-tour-of-sri-lanka-2021-1262739/sri-lanka-vs-india-2nd-odi-1262756/full-scorecard");
		
		//a[text()='Avishka Fernando']//parent::td//following-sibling::td/span
	
	    System.out.println(getWicketTakerName("Avishka Fernando"));
	    System.out.println(getWicketTakerName("Charith Asalanka"));
	    System.out.println(getWicketTakerName("Bhanuka Rajapaksa"));
	    System.out.println(getWicketTakerName("Dhananjaya de Silva"));	
	
	
	}
	
	public static String getWicketTakerName(String playerName) {
		
		String wicketTaker = "//a[text()='"+playerName+"']//parent::td//following-sibling::td/span" ;
	    return driver.findElement(By.xpath(wicketTaker)).getText();
	}
	

}
