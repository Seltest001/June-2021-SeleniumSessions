package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownOptionsSelect {
	
	static WebDriver driver;
	
	public static void main(String [] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//Create By locator:
		By indus_dd = By.id("Form_submitForm_Industry");
		By country_dd = By.id("Form_submitForm_Country");
		
		//Create WebElement:
//		WebElement industry_dd = driver.findElement(indus_dd);
//		WebElement country_dropdown = driver.findElement(country_dd);
//		
//		//Create an Object of Select class:
//		Select select = new Select(industry_dd);
//		List<WebElement>indusList = select.getOptions();
//		System.out.println(indusList.size());
//		
//		for(WebElement e : indusList) {
//			String text = e.getText();
//			System.out.println(text);			
//		}
//		
//		System.out.println("-------------------------");
//
//		Select sel = new Select(country_dropdown);
//		List<WebElement> countryList = sel.getOptions();
//		System.out.println((countryList.size()));
//     	for (WebElement ele : countryList) {
//			String ele1 = ele.getText();
//			System.out.println(ele1);
//		}
//     	
//     	System.out.println("--------------------------");
//     	driver.close();
		
		//*******************************************************//
		
		
		List<String>indusList = getDropDownOptionsList(indus_dd);
		if(indusList.size() == 21) {
			System.out.println("TC_01 : Pass");
		}
		if(indusList.contains("Healthcare")) {
			System.out.println("TC_02 : Pass");
		}
		System.out.println("--------------------------------------------");
		//getDropDownOptionsList(country_dd);
		
		selectDropDownValue1(country_dd,"Belgium");
		
		//driver.close();

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<String> getDropDownOptionsList(By locator) {
		List<String>optionsValList = new ArrayList<String>();
		 Select select = new Select(getElement(locator));
		 List<WebElement>optionsList = select.getOptions();
		 
		 System.out.println(optionsList.size());
		 
		 for(WebElement e : optionsList) {
			 String text = e.getText();
			 optionsValList.add(text);
			 
		 }
		 return optionsValList;
		 
	}
		 
	public static void selectDropDownValue1(By locator, String value) {
		Select select1 = new Select(getElement(locator));
		List<WebElement> optionsList1 = select1.getOptions();
		System.out.println(optionsList1.size());

		for (WebElement e : optionsList1) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}

		}

	}

}
