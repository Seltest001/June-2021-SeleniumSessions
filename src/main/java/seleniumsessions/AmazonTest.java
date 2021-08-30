package seleniumsessions;

import org.openqa.selenium.WebDriver;

public class AmazonTest {
	
	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();

		WebDriver driver = br.launchBrowser("chrome");

		br.launchUrl("https://www.amazon.com");

		String title = br.getPageTitle();
		System.out.println("Page title :  " + title);
		
		if (title.contains("Amazon")) {
			System.out.println("Title is correct");
		} else {
			System.out.println("Title is incorrect");
		}

		String url = br.getPageUrl();
		System.out.println(url);

		br.getCurrentPageSource();
		System.out.println(driver.getPageSource().contains("amazon"));

		br.closeBrowser();

		// br.quitBrowser();

	}

}
