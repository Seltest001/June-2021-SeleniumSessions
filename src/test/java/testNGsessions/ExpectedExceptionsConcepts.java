package testNGsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionsConcepts {
	
	//How will you ignore the Expected Exceptions in TestNG?

	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void homePageTest() {
		System.out.println("home page test");
		//int i = 9/0;
		ExpectedExceptionsConcepts obj = null;
		System.out.println(obj);
	}
	
	//this test will fail and will give null pointer exception, since it is pointing to null object (exceptions mismatch)
	
	/*Uncomment int i=9/0; ==> test will pass, exceptions will match (declared and execution exception will match)
	 * and execution will terminate from the passed test, it wont execute from line#11
	 * we can define multiple exceptions.this test might throw arithmetic and null pointer exceptions
	 * expected exception is a class array
	 */

}
