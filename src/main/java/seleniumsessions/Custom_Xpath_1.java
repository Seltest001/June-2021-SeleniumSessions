package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_1 {
	static WebDriver driver;
	
	public static void main (String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//xpath is the address of element in HTML DOM
		//1.Absolute xpath: Always risky, position change
		//2.Relative xpath: 
		
		//htmltag[@attr = 'value']
		//input[@id='input-email']
		//input[@name = 'email']		
		
		//htmltag[@attr1='value' and @attr2='value']
		//input[@name='email' and @type='text']
		//input[@type='submit' and @value='Login']
		
		// a ---> FindElements(xpath), TotalLinks

		// Indexing concept in xpath:
		// (//input[@class='form-control']) [1]
		// the parenthesis is called 'capture group'

		// " position" is the in-built function in xpath
		// (//input[@class='form-control']) [position()=1]

		// OR --> operator
		// input[@type = 'text' or @type = 'email']

		// last():
		// (input[@class='text'])[last()]
		// (//div[@class='navFooterVerticalRow navAccessibility']//a)[last()]
		// (//div[@class='navFooterVerticalRow navAccessibility']//a)[position()=last()
		// we have only "last" function, No "first" function.
		
		//xpath with text() function:
		//htmltag[text()='value']
		//a[text()='Login']
		//h2[text()='Refreshing business software that your teams will love']
		//h3[text()='Marketing Campaigns']
		//For LABELS,HEADERS,SPANS --> we can easily use text() function
		
		//contains():
		//htmltag[contains(@attr, 'value')]
		//input[contains(@id,'input-email')]
		//Usescases for contains() function are dynamic elements with
		//dynamic attributes which changes while refreshing the application,loading the page
		//<input id ="firstname_123">
		//<input id ="firstname_234">
		//<input id ="firstname_456">
		
		
		//input[contains(@id,'firstname_')]
		
		//contains() with text():
		//htmltag[contains(text(),'value')]
		//a[contains(text(),'Order')]
		//h2[contains(text(),'business software')]
		
		//contains with one attribute and second attribute without contains?is it possible?
		//htmltag[contains(@attr1,'value') and @attr2='value']
		//input[contains(@id,'email') and @type='text']
		//input[contains(@id,'email') and @type='text' and contains(@name,'email')]
		
		//contains() with text() and attributes:
		//htmltag[contains(text(),'value') and @attr ='value']
		//a[contains(text(),'Contact Sales') and @href = '/contact-sales/']
		
		//contains() with test() and contains with attributes:
		//a[contains(text(),'Contact Sales') and contains(@class,"btn-orange')]
		
		  //starts-with:
		 //h2[starts-with(text(),'Refreshing')]
		//dynamic elements with dynamic attributes
//       <input id ="firstname_123">
//       <input id ="firstname_234">
//       <input id ="firstname_456">
		//input[starts-with(@id,'firstname_')]
		//input[contains(@id,'email)and @type='text' and contains(@name,'email')]
		
		//*[@type ='text']-- 3 elements/match, Asterik *-> not preferred
		//input[@type='text']--3 match,  preferred
		
		//https://app.hubspot.com/login
		
        By b1 = By.className("form-control private-form__control login-email");  //Incorrect
	    By b2 = By.xpath("//input[@class='form-control private-form__control login-email']"); //Correct
		By b3 = By.cssSelector(".form-control.private-form__control.login-email");  //Correct
		By b4 = By.className("login-email");  //Correct
		
		//By.className should not have multiple classes together,seperated by spaces.
		//It should have only one unique className
		
		String xpath1 = "//input[@name=\"email\"]";
		String xpath2 = "//input[@name='email']";
		
		
		String loginLink = "Register";
		
//		By email = getBy("xpath", xpath1);
//		getElement(email).sendKeys("Rupa");
		
		getElement("xpath", xpath1).sendKeys("Rupa");
		getElement("linkText",loginLink).click();
						
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement getElement(String locatorType,String locatorValue) {
		return driver.findElement(getBy(locatorType,locatorValue));
	}
	
	
	public static By getBy(String locatorType,String locatorValue) {
		
		By locator = null;
		
		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "className":
			locator = By.className(locatorValue);
			break;
		case "tagName" :
			locator = By.tagName(locatorValue);
			break;
		case "linkText" :
			locator = By.linkText(locatorValue);
			break;
		case "partialLinkText" :
			locator = By.partialLinkText(locatorValue);
			break;
		case "xpath" :
			locator = By.xpath(locatorValue);
			break;
		case "cssSelector" :
			locator = By.cssSelector(locatorValue);
			break;
			
			default:
				System.out.println("Please pass the correct locator :"+ locatorType);
				break;			
		}
		return locator;				
		
	}	

}
