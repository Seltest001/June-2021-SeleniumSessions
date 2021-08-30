package testNGsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcepts {
	
	/*never use dependency for test methods
	 * test methods should be independent
	 * CRUD - POST,GET,Update,Delete
	 * create the user -- 125
	 * get the same user --125	 
	 * AAA rule--This is always a recommended way to write the
	 * test cases.	 
	 */

	@Test
	public void loginTest() {
		System.out.println("login test");
		int i = 10/2;
	}

	@Test(dependsOnMethods = "loginTest", priority=2)
	public void homePageTest() {
		System.out.println("home page test");
		int i = 9/0;
	}

	@Test(dependsOnMethods = "loginTest", priority=1)
	public void searchTest() {
		System.out.println("search test");
	}

}
