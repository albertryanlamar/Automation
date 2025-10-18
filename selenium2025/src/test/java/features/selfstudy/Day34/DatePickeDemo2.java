package features.selfstudy.Day34;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class DatePickeDemo2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement dates = driver.findElement(By.xpath("//input[@id='txtDate']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dates);
		dates.click();
		
		String date = "2";
		String month = "January";
		String year  = "2025";

	}
	
	public static void setdate(String date, String month, String year) {
		
		
	}

}
