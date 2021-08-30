package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://www.seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		WebElement cal = driver.findElement(By.id("datepicker"));
		cal.click();
		Thread.sleep(1000);

//		WebElement ele = driver.findElement(By.xpath("//a[text()='31']" ));
//		ele.click();
//		
//		List<WebElement> daysList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));
//		for (WebElement e : daysList) {
//			if(e.getText().equals("25")) {
//				e.click();
//				break;
//			}
//			
//		}

		selectFutureDate("December 2021", "35");

	}

	public static void selectFutureDate(String ExpMonthYear, String date) {

		if (Integer.parseInt(date) > 31) {
			System.out.println("Wrong date passed....please pass the correct date!");
			return;
		}

		String actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		System.out.println(actMonthYear);

		while (!actMonthYear.equals(ExpMonthYear)) {
			// click on next
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//			driver.findElement(By.xpath("//span[text()='Prev']")).click();

		}

		driver.findElement(By.xpath("//a[text()='" + date + "']")).click();

	}

}
