package features.selfstudy.day26;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driv = new ChromeDriver();
		
		//opens the url browser
		driv.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driv.manage().window().maximize();
		// rreturn the url of the page
		driv.getCurrentUrl();
		//returns the tile of the page
        driv.getTitle();
        // source code validation - not important retrurns the page source of the page
		//driv.getPageSource();
		//getwindowhandle() - returns of the single browser window
        
	    //String windowID = driv.getWindowHandle();
		//System.out.println(windowID);
		
		driv.findElement(By.linkText("OrangeHRM, Inc")).click();
        //new WebDriverWait(driv, Duration.ofSeconds(10))
        //.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'OrangeHRM')]")));
		Set<String> windowid = driv.getWindowHandles();
		System.out.println(windowid);
		
	}

}
