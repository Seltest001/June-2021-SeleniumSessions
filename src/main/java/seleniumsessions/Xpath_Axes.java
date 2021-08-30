package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Axes {
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception  {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		
		//selectContact("Aastha Grover");
		selectContact("Akshay patil");
		//selectContact("Yadav Vaibhav");
		
		
		
		// parent to child:forward traversing

		// direct child: / -->8 matches
		// indirect + direct child: // -->20 matches

		// 01 //div[@class='private-form__input-wrapper']/input --> direct parent
		// 02 //div[@class='private-form__input-wrapper']//child::input[@id='username']--> direct child
		
		// ****************************************************************************

		// we always traverse from top to bottom.can we go from bottom to top? YES
		// It's called backward traversing.It is possible in Xpath but not in CSS.
		// it is called child to parent.

		// *****************************************************************************

		// child to parent:backward traversing

		// 03 //input[@id ='username']/../../../../../../../../../..
		// (this will reach top of the page or first parent node ie.,HTML tag)

		// 04 //input[@id='username']//parent::div -->immediate parent
		// 05 //input[@id='input-email']//parent::div -->01 immediate parent

		// (Ancestor-->this will give all grandparents)
		// 06 //input[@id='input-email']//ancestor::div-->all parents-->20

		//************************************************************************************
		
		// sibling traversing: www.crmpro.com, webtables
		// preceding-sibling
		// following-sibling

		// 07 //a[text()='Aastha Grover']//parent::td//preceding-sibling::td/input[@type='checkbox']
		// 08 //a[text()='AB Devilliers']//parent::td//preceding-sibling::td/input[@type='checkbox']
		// 09 //a[text()='Akshay Patil']//parent::td//preceding-sibling::td/input[@type='checkbox']

	}
	
	public static void selectContact(String name) {
		String checkBox = "//a[text()='"+name+"']//parent::td//preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(checkBox)).click();
	}

}
