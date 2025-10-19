package features.selfstudy.day26;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignments_day26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//get method
		driver.get("https://testautomationpractice.blogspot.com/");
		//get title
		String webTitle = driver.getTitle();
		System.out.println("The title of the webpage is "+ webTitle);
		//get the url  of the page
		String webUrl = driver.getCurrentUrl();
		System.out.println("The Url of the page: " + webUrl);
		
		//get window handle
		String parentWindowID = driver.getWindowHandle();
		System.out.println("Window ID: " + parentWindowID);
		
		/**************** Condtional Methods ****************/
		//finds description text is displayed
		boolean text1 = driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']")).isDisplayed();
		System.out.println("Text1 is Displayed" + text1);
		
		//enabled
		boolean fname = driver.findElement(By.xpath("//input[@id='name']")).isEnabled();
		boolean email = driver.findElement(By.xpath("//input[@id='email']")).isEnabled();
		boolean phone = driver.findElement(By.xpath("//input[@id='phone']")).isEnabled();
		boolean address = driver.findElement(By.xpath("//textarea[@id='textarea']")).isDisplayed();
		System.out.println("Name is enabled: " + fname);
		System.out.println("Email is enabled: " + email);
		System.out.println("phone is enabled: " + phone);
		System.out.println("Address is enabled: " + address);
		
		//status before selected the radio button
		
		//using for each loop
		List<WebElement> gender = driver.findElements(By.xpath("//input[@name='gender']"));
		for(WebElement g : gender) {
			if(!g.isSelected()) {
				System.out.println("Address is not selected: " + g.getAttribute("value"));
			}
			else {
				System.out.println("Address is selected: " + g.getAttribute("value"));
			}

		}
		
		//status before selected of checkbox
		List<WebElement> chck = driver.findElements(By.xpath("//label[text()='Days:']/following-sibling::div//input[@type='checkbox']"));
		for(WebElement c : chck)
		{
			if(!c.isSelected()) {
				System.out.println(c.getAttribute("value") + " is not selected ");
			}
			
		}
		
	}

}
