package seleniumsessions;

public class SeleniumWaits {
	
	//WebDriverWait(c)-->FluentWait(c)==>Wait(I)-- until();
	//public class WebDriverWait extends FluentWait {
	
	//public class FluentWait<T> implements Wait<T> {
	
	//WebDriverWait--> 1 method(timeOutException())- overridden
	//zero individual methods
	
	// FluentWait:available methods:	
	//until, ignoring-->ignoreAll,pollingEvery,withMessage,withTimeout,
	//FluentWait v/s WebDriverWait==>Both are same, only 1 difference is
	//WebDriver wait has one overridden method timeOutException(); method.
	//zero individual methods in webdriver wait class
	
	//Explicitly Wait is WebDriver wait and Fluent wait
	//What if I need to use WebDriver wait with more features,which I define with
	//FluentWait? I want to inherit those features here.
	
	
	//create an object of FluentWait--this is different:
	//create an object of FluentWait and give the generics over here,what type of generics?Where we have to give?
	//we have to apply Fluentwait on the WebDriver,we have one constructor here and
	//we have to give 1 driver here, we have to topcast-->child class object is referred by parent interface reference variable
	//Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	//call All the methods of Fluent Wait with this object reference
	//withTimeOut(); withMessage(); pollingEvery();  ignoring();  ignoreAll();
	
	//Implicitly Wait + Explicitly Wait (webdriver wait OR fluent wait )
	//Never mix both the waits together
	//Explicitly wait will not override Implicitly wait.They both are different.
	//cumulative waits, if both are declared , it will be applied together
    //we shouldnot use fluent wait and webdriver wait together
	//Explicitly wait is the best wait to use.
	
	//Exception messages:
	
	//Explicitly wait will throw--> No such element exception as-well as Time out exception	
	//Implicitly wait will throw--> No such element exception
}
