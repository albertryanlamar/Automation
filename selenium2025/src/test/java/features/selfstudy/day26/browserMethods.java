package features.selfstudy.day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driv = new ChromeDriver();
		
		//opens the url browser
		driv.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driv.findElement(By.linkText("OrangeHRM, Inc")).click();
		driv.close();
		driv.quit();

	}

}
