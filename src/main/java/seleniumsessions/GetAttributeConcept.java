package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		// webelement + get Attribute
		// create a webelement, instead of performing actions like .click or
		// other, perform GetAttribute action.
		// GetAttribute action says "you give me the attribute name you wanted to
		// pick, it will return that string.

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/register");

		By login = By.linkText("Login");
		By search = By.name("search");

		//String hrefval = driver.findElement(login).getAttribute("href");
		//System.out.println(hrefval);					

		String text = doGetAttribute(login, "href");
		System.out.println(text);

		if (doGetAttribute(login, "href").contains("login")) {
			System.out.println("login link is having correct href value");			
		}
		String placeHoldValue = doGetAttribute(search,"placeholder");
		System.out.println(placeHoldValue);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);

	}

}
