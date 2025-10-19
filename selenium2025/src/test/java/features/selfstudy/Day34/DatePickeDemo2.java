package features.selfstudy.Day34;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
		String month = "Jan";
		String year  = "2023";
		
		setdate(date,month,year,driver);

	}
	
	static Month convertMonth(String month) {
		HashMap<String, Month> con = new HashMap<String, Month>();
		
		con.put("Jan", Month.JANUARY);
		con.put("Feb", Month.FEBRUARY);
		con.put("Mar", Month.MARCH);
		con.put("Apr", Month.APRIL);
		con.put("May", Month.MAY);
		con.put("Jun", Month.JUNE);
		con.put("Jul", Month.JULY);
		con.put("Aug", Month.AUGUST);
		con.put("Sep", Month.SEPTEMBER);
		con.put("Oct", Month.OCTOBER);
		con.put("Nov", Month.NOVEMBER);
		con.put("Dec", Month.DECEMBER);
		
		Month vmonth = con.get(month);
		
		if(vmonth==null) {
			System.out.println("Invalid Month");
		}
		
		return vmonth;
	}
	
	public static void setdate(String date, String month, String year, WebDriver driver) {
		
		//selecting months
		WebElement months = driver.findElement(By.xpath(" //select[@aria-label='Select month']"));
		Select m = new Select(months);
		List<WebElement> ohhh =  m.getOptions();
		//2nd way to compare
		for(WebElement aaah: ohhh) {
			System.out.println(aaah.getText());
			
			//1st way
			if(aaah.getText().equalsIgnoreCase(month)) {
				aaah.click();
				break;
				
			}
		}
		//2nd way to compare
		/* Month expectedmonth =  convertMonth(month);
		Month  currentmonth= convertMonth(months.getText());
		//compare
		int result = expectedmonth.compareTo(currentmonth); // if result is 0 = month are equl, if >0 this is future month, if <0 it is past month 
		 if(result > 0) {
			 System.out.println("Future Date will select the expect month");
		 }
		 if(result < 0) {
			 
		 }
		 else {
			 
			 
		 } */

		
		// end of selecting months
		
		//selecting year
		WebElement  selectyear = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
	
		Select y = new Select(selectyear);
		
		List<WebElement> yr = y.getOptions();
		for(WebElement yrs : yr) {
			if(yrs.getText().equalsIgnoreCase(year)) {
				yrs.click();
				break;
			}
		}
		

		
	   // end of selecting year
		
	   // day
		List<WebElement> day = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));
		for(WebElement sday: day) {
			if(sday.getText().equalsIgnoreCase(date)) {
				sday.click();
				break;
			}
		}
		
	}

}
