package features.selfstudy.day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();

		Set<String> windowIDS = driver.getWindowHandles();
	    
		/* // approach 1 suitable for having a 3 windows
		List<String> windowlist = new ArrayList(windowIDS);
		
		String parentID = windowlist.get(0);
		String childID = windowlist.get(1);
		
		//switch to child window
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());
		
		//switch to parent window
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		*/
		
		//approac 2  this is suitable for more than 3 windowhandles
		for(String windID : windowIDS) 
		{
			String title = driver.switchTo().window(windID).getTitle();
			System.out.println(title);
		}
		
	}

}
