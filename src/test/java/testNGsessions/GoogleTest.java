package testNGsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test(priority=1)
	public void pageTitleTest() {		
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, "Google");
		System.out.println("--------------------------------------------------");
	}

	@Test(priority=2)
	public void appPageUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("Page url: " + url);
		Assert.assertTrue(url.contains("google"));
	}

}
