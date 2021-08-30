package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCSS {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get();
	}
	
	//CSS:Cascaded Style Sheet
	//cssSelector: is a locator but not an attribute
	
	//id:
	//#{id}---> #txtUsername
	//tag#id-->input#txtUsername
	//input#Form_SubmitForm_FirstName
	
	//class:
	//.{class}-->.login-email
	//tag.class-->input.login-email
	//tag.c1.c2.c3....cn-->input.form-control.private-form_control.login-email
	
	By css1 = By.cssSelector ("input.login-email");
	By css2 = By.cssSelector (".form-control.private-form_Control.login-email");
	
	//id&class:	
	//#id.class-->#input-email.form-control
	//.class#id-->.form-control#input-email
	//tag#id.class--> input#username.login-email
	//tag.class#id-->input.login-email#username
	//tag.c1.c2.c3..cn#id-->input.form-control.private-form_control.login-email#username
	//input#username.form-control.private-form_control.login-email
	
	//other attributes:
	//tag[attr = 'value']
	//input[id='input-email']
	//input[name='email']
	//input[name='email'][type='text'][placeholder='E-Mail Address']
	
	//  input[id='input-email'] -->css
	//input[@id='input-email']-->xpath
	
	// contains in css:
	// tag[attr*='value']--> input[id*='FirstName']
	// input[id*='FirstName'][name='FirstName']
	
	//starts with in css:
	// tag[attr^='value']--> input[name^='First']
	
	//ends with in css:
    //  tag[attr$='value']--> input[name$='Name']
	
	//parent to child:
	//  form#hs-login div -->20 matching elements,direct+indirect
	//  form#hs-login>div --> 8 matching elements,direct
	//  div.navFooterVerticalRow.navAccessibility > div a --> 22
	//  div.navFooterVerticalRow.navAccessibility a --------> 22
	
	//( line.65 and line.66 both are same with diff syntax)
	// ul.footer-nav a -->22
	// select#Form_submitForm_Industry > option
	
	 List<WebElement> indusList =
	driver.findElements(By.cssSelector("select#Form_submitForm_Industry > option"));
	
	//child to parent: NO backward traversing is allowed in CSS
	
	//not in css:
	//  :not
	//form-control private-form_control login-email(classes of email, hubspot.com)
	//form-control private-form_control m-bottom-3(classes of password, hubspot.com)
	
	//input.form-control.private-form_control:not(#username)
	//input.form-control.private-form_control:not(#password)
	//input.text:not(#Form_submitForm_Jobtitle)
	//input.text:not(#Form_submitForm_Jobtitle,[name='FirstName']
	
	//Q: How to exclude from the group?
	//A: By using :not(#attr)--> :not(pass the attribute)
	
	 //comma in css:
	 //input#username,input#password,button#loginBtn, a[href*='signup']
	 
	 List<WebElement>mandFields = driver.findElements(By.cssSelector("input#username,input#password, button#loginBtn, a[href*='signup']"));
			 
	// if (mandFields.size()== 4){
		 
		// System.out.println("PASS -- all mandatory elements are present on the page");
	 //}
	 
	 
	 
     	
}
	
	
	
	
	


