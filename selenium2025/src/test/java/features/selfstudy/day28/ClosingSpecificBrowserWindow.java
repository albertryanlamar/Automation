package features.selfstudy.day28;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClosingSpecificBrowserWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();

		Set<String> windowIDS = driver.getWindowHandles();
		
		for(String windID : windowIDS) 
		{
			String title = driver.switchTo().window(windID).getTitle();
			System.out.println(title);
			
			if(title.equals("OrangeHRM")) {
				//driver.switchTo().window(title);
				driver.close();
			}
		}
	}

}
