package testNGsessions;

import org.testng.annotations.Test;

public class InvocationCountConcepts {
	
	//same test will be executed for specified number of times.
	//same will be converted into eg., 10 times,output will be 10
	
	@Test(invocationCount = 5)
	public void homePageTest() {
		System.out.println("home page test");
	}

}
