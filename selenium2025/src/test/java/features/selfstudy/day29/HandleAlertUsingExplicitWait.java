package features.selfstudy.day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlertUsingExplicitWait {

	//handle alert wiyout using switchTo()
	// by using explicitwait
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		
		Alert myalert = mywait.until(ExpectedConditions.alertIsPresent());
		
	    System.out.println(myalert.getText());
	    myalert.accept();
	}

}
