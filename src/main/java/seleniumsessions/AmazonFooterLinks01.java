package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonFooterLinks01 {

	
	public static void main(String[] args) {

		BrowserUtil browser = new BrowserUtil();

		WebDriver driver = browser.launchBrowser("chrome");

		browser.launchUrl("https://www.amazon.in/");

		String title = driver.getTitle();
		System.out.println(title);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		By footerLinks = By.xpath("//div[@class='navFooterVerticalRow navAccessibility']//a");

		ElementUtil eleUtil = new ElementUtil(driver);
		List<WebElement> footerList = eleUtil.getElements(footerLinks);
		System.out.println(footerList.size());

		for (WebElement e : footerList) {
			String s1 = e.getText();
			System.out.println(s1);

		}

		driver.close();

	}

}
