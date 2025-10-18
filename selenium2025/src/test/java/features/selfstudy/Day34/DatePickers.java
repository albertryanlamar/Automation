package features.selfstudy.Day34;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickers {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		//method1 using sendkeys()
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/12/2025");
		
		//method2 using date picker
		String year = "2025";
		String month = "October";
		String date = "1";
				
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		
		while(true) {
			String currentmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(currentmonth.equalsIgnoreCase(month) && currentyear.equals(year)) {
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		   List<WebElement> dates = driver.findElements(By.xpath("//tbody//tr//td//a"));
		   
		   for(WebElement a: dates) {
			   System.out.println(a.getText());
			   
			   if(a.getText().equals(date) && a.getAttribute("class").contains("ui-state-highlight")) {
				   break;
			   }
			   if(a.getText().equals(date) && !a.getAttribute("class").contains("ui-state-highlight")){
				   try {
				   a.click();
				   }
				   catch(Exception e) {
					   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", a);
				   }
				   break;
			   } 
		   }
		
		
		
		

	}

}
