package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLanguageLinks {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.walmart.com");
		String url = driver.getTitle();
		System.out.println(url);

		By text = By.xpath("//*[@id=\"js-global-footer-wrapper\"]/div/div[4]/span[1]");
		WebElement footer = driver.findElement(text);
		System.out.println(footer.getText());
		String text1 = footer.getText();
		System.out.println(text1);
		driver.close();

	}

}
