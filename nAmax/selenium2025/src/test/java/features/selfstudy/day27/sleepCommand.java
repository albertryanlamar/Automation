package features.selfstudy.day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sleepCommand {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driv = new ChromeDriver();
		
		driv.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driv.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driv.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("aa");
	}

}
