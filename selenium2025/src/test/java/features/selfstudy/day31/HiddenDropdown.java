package features.selfstudy.day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenDropdown {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//click on PIM
		driver.findElement(By.xpath("//a//span[text()='PIM']")).click();
		
		//click on Dropdown
		driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[3]")).click();
		
		//select single option
		//driver.findElement(By.xpath("//span[normalize-space()='Automaton Tester']")).click();
		
		//select on dropdown using conditions
		List<WebElement> aa = driver.findElements(By.xpath("//div[@role='listbox']/div[@class='oxd-select-option']/span"));
		System.out.println("Dropdown options count: " + aa.size());
		
        aa.forEach(el -> System.out.println(el.getText().trim()));
        aa.stream()
                  .filter(el -> el.getText().trim().equalsIgnoreCase("Automaton Tester"))
                  .findAny()
                  .ifPresentOrElse( el ->{
                	  el.click();
                	  System.out.println("Able to select Account Assistant");
                	  }, 
                      () -> System.out.println("System not found")
                  );

	}

}
