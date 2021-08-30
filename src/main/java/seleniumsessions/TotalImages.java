package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {
	
	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		// Get the count of all images
		// images --> <img>

		By images = By.tagName("img");
		List<WebElement> imagesList = getImages(images);
		System.out.println("Total count of images :  " + imagesList.size());

//		for(int i=0; i<imagesList.size(); i++) {
//			 String altValue = imagesList.get(i).getAttribute("alt");
//			 String srcValue = imagesList.get(i).getAttribute("src");
//			 System.out.println(altValue + "-->" + srcValue);
//		}

		// for each loop:
        int i = 1; 
		for (WebElement e : imagesList) {
			
			String altValue = e.getAttribute("alt");
			String srcValue = e.getAttribute("src");

			System.out.println(i+altValue);
		    System.out.println(i+srcValue);
		    i++;
			
		}
		

		//driver.close();

	}

	public static List<WebElement> getImages(By locator) {
		return driver.findElements(locator);

	}

}
