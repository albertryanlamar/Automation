package features.selfstudy.day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class implicitWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driv = new ChromeDriver();
		
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// applicable for all the line of codes
		
		driv.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driv.manage().window().maximize();
		
		
		driv.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("aa");
	}

}
