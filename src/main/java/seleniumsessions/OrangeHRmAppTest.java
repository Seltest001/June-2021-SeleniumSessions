package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRmAppTest {
	
	public static void main(String[] args) {

		String browser = "chrome";

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser(browser);
		brUtil.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");

		System.out.println(brUtil.getPageTitle());

		By first1Name = By.id("Form_submitForm_FirstName");
		By secondName = By.id("Form_submitForm_LastName");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(first1Name, "Shreyu");
		eleUtil.doSendKeys(secondName, "Karu");

		brUtil.closeBrowser();

	}

}
