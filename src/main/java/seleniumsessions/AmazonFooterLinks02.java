package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooterLinks02 {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		System.out.println("------------------------------");
		System.out.println(driver.getTitle());
		System.out.println("------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println("-------------------------------");

		By footerLinks = By.xpath("//div[@class='navFooterVerticalRow navAccessibility']//a");

//		ElementUtil eleUtil = new ElementUtil(driver);
//		List<WebElement> footerList = eleUtil.getElements(footerLinks);
//
//		System.out.println(footerList.size());
//		System.out.println("---------------------------------");
//
//		for (WebElement e : footerList) {
//			System.out.println(e.getText());
//		}
		
		List<String> footerTextList = getLinksTextList(footerLinks);
		
		//validation/check points:
		if(footerTextList.size() == 22) {
			System.out.println("Footer list count are correct! ");
			System.out.println("---------------------------------");
		}
		if(footerTextList.contains("About us")) {
			System.out.println("About us is present");
		}

		driver.close();

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static List<String> getLinksTextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();

		List<WebElement> eleList = getElements(locator);
		System.out.println("Element count : " + eleList.size());

		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}

		for (String e1 : eleTextList) {
			System.out.println(e1);
		}
		
		System.out.println("---------------------------------");
		
		return eleTextList;

	}

}
