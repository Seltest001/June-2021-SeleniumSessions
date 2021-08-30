package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownHandle {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		System.out.println("-----------------------------------");
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println("-------------------------------------");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		System.out.println("-------------------------------------");
		
		By industryDd = By.id("Form_submitForm_Industry");
		By countryDd = By.id("Form_submitForm_Country");
		
		//doSelectByVisibleText(industryDd,"Education");
		//doSelectByVisibleText(countryDd,"Canada");
		doSelectByIndex(countryDd, 8);
		doSelectByIndex(industryDd, 10);

//		WebElement indus_ele = driver.findElement(industryDd);
//		WebElement country_ele = driver.findElement(countryDd);
//		
//		Select sel = new Select(indus_ele);
//		//sel.selectByIndex(5);
//		sel.selectByValue("health");
//		//sel.selectByVisibleText("Aerospace");
//		
//		Select sel1 = new Select(country_ele);
//		//sel1.selectByIndex(6);
//		sel1.selectByValue("Canada");
//		//sel1.deselectByVisibleText("Brazil");
//		
//		//driver.close();

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static void doSelectByValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

}
