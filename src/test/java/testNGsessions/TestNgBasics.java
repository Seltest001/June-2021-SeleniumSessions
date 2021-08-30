package testNGsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {

	/*
	 * 1.Pre-conditions 2.Test case==> Test steps + Assertions(validations, Actual
	 * v/s Expected) 3.Post steps
	 */

	@BeforeSuite
	public void DBConnection() {
		System.out.println("BS--DB Connection");
	}

	@BeforeTest
	public void createUser() {
		System.out.println("BT--create user");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC launch browser");
	}

	@BeforeMethod
	public void loginTest() {
		System.out.println("BM--login");
	}

	@Test // 01
	public void homePageTest() {
		System.out.println("homepage-Test");
	}

	@Test // 02
	public void addToCartPageTest() {
		System.out.println("Add to cart page -Test");
	}

	@Test // 03
	public void paymentPageTest() {
		System.out.println("PaymentPage Test");
	}

	@AfterMethod
	public void logOut() {
		System.out.println("After method logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("After class --closeBrowser");
	}

	@AfterTest
	public void deleteUSer() {
		System.out.println("AfterTest delete user");
	}

	@AfterSuite
	public void disConnectDB() {
		System.out.println("After suite disconnectDB");
	}

}
