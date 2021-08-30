package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	static WebDriver driver;
	
	public static void main(String [] args) {
		
		WebDriverManager.chromedriver().setup();
		
	    driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//create a webelement + perform an action (click, sendkeys,getText, isDisplayed)
				
		//1st approach:
		
//		driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("Shreyu");
//		driver.findElement(By.id("Form_submitForm_LastName")).sendKeys("Karu");
//		driver.findElement(By.id("Form_submitForm_Email")).sendKeys("shreyu@gmail.com");
//		driver.findElement(By.id("Form_submitForm_JobTitle")).sendKeys("Doctor");
//		driver.findElement(By.id("Form_submitForm_CompanyName")).sendKeys("Duke UH");
//		driver.findElement(By.id("Form_submitForm_Contact")).sendKeys("123-456-7890");
		
		//----------------------------------------------------------------------------------------------
		
		//2nd approach:
		
//		WebElement firstName = driver.findElement(By.id("Form_submitForm_FirstName"));
//		WebElement lastName = driver.findElement(By.id("Form_submitForm_LastName"));
//		
//		firstName.sendKeys("Shreyu");
//		lastName.sendKeys("Karu");
		
		//------------------------------------------------------------------------------------------------
		
		//3rd approach: By locator(the return type of By.id method is "By"
		
//		By firstName = By.id("Form_submitForm_FirstName");
//		By secondName = By.id("Form_submitForm_LastName");
//		
//		WebElement fn_ele = driver.findElement(firstName);
//		WebElement ln_ele = driver.findElement(secondName);
//		
//		fn_ele.sendKeys("Shreyu");
//		ln_ele.sendKeys("Karu");
		
		//----------------------------------------------------------------------------------------------------
		
		//4th approach:generic method:	
		
//		By firstName = By.id("Form_submitForm_FirstName");
//		By secondName = By.id("Form_submitForm_LastName");			
//		
//		getElement(firstName).sendKeys("Shreyu");
//		getElement(secondName).sendKeys("Karu");
		
		//------------------------------------------------------------------------------------------------------
		
		//5th approach: using generic methods for actions:
		
//		By firstName = By.id("Form_submitForm_FirstName");
//		By secondName = By.id("Form_submitForm_LastName");
//
//		doSendKeys(firstName, "Shreyu");
//		doSendKeys(secondName, "Karu");
		
		//---------------------------------------------------------------------------------------------------------
		
		//6th approach: create a new ElementUtil class with generic functions.
		//Below are the 8 locators, they are available in the "By" class in the form of "Methods".you call those
		//Methods and pass the respective values.
		//ClassName, Id and Name are the only 3 attributes.We have Methods only for these 3 attributes
		//Xpath, CSS Selector, Text are not attributes.
		//Id is always Unique-->1st pick, Name--can be duplicate, 2nd-->pick, ClassName-->3rd pick if it is unique.
		//Partial LinkText is not recommended.
		//Xpath and CSS Selector-- Both are better performance, but ranking goes to Xpath
		//TagName-- if it is unique.
		//1.Id, 2.Name, 3.ClassName, 4.Xpath/CSS Selector
        
		
		//1. By id
		
//		By firstName = By.id("Form_submitForm_FirstName");
//		By secondName = By.id("Form_submitForm_LastName");
		
		ElementUtil eleutil = new ElementUtil(driver);
//		eleutil.doSendKeys(firstName, "Shreyu");
//		eleutil.doSendKeys(secondName, "Karu");
//		
		//2. By name
		
//		By fn = By.name("FirstName");
//		eleutil.doSendKeys(fn,  "Shreyu");
//		
//		By ln = By.name("LastName");
//		eleutil.doSendKeys(ln, "Karu");
		
		 By agreeCheckBox = By.name("agree");
		 doClick(agreeCheckBox);
		 
		
		//3. By className
		
//		By fn = By.className("text");
//		eleutil.doSendKeys(fn, "Shreyu");
		
		//4.By linkText
		
		 By ltxt = By.linkText ("Login");
		 eleutil.doSendKeys(ltxt, "Shreyu");
		 
		 //5.By partial link text:only for links, for 'a' tags
		 
		 By partiallnkTxt = By.partialLinkText("Forgotten");
		 doClick(partiallnkTxt);
		 
		 //6.xpath: is a locator:address of the element in DOM
		 //xpath is not an attribute
		 
		 By fName = By.xpath("//*[@id=\"Form_submitForm_FirstName\"]");
		 doClick(fName);
		 doSendKeys(fName, "Shreyu");
		 
		 //7. CSS locators:Cascading Style Sheets. css is a locator
		 //not an attribute
		 
		  By fn_css = By.cssSelector("#Form_submitForm_FirstName");
		  doSendKeys(fn_css, "Shreyu");
		  doClick(fn_css);
		  
		  //8. tagName: html tag
		  By header = By.tagName("h2");
		 // String text = driver.findElement(header).getText();
		  String text= doGetText(header);
		  System.out.println(text);
		 
		 	
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}
	
	public static void doSendKeys(By locator,String value) {//		
		getElement(locator).sendKeys(value);
		
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
		
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	

}
