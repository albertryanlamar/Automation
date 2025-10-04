package features.selfstudy.Day32;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
		Thread.sleep(5000);
		
		List<WebElement> lst = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']//div[1]//span"));
		
		System.out.println(lst.size());
		//using lambda expressions
		lst.forEach(el -> System.out.println(el.getText().trim()));
	    lst.stream()
	               .filter(el -> el.getText().trim().equalsIgnoreCase("selenium"))
	               .findAny()
	               .ifPresentOrElse(el ->
	               						{
	               							el.click();
	               							System.out.println("Able to Select");
	               						}, 
	               						() -> System.out.println("Not Found") 
	               );
	    
	    
	    


	}

}
