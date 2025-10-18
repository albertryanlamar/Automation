package features.selfstudy.day28;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://demo.nopcommerce.com"); get accepts only a url in the string format
		//driver.navigate().to("https://demo.nopcommerce.com");
		
		// try {
		//	URL myurl = new URL("https://demo.nopcommerce.com");
		//	driver.navigate().to(myurl);
		// } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		driver.navigate().to("https://demo.nopcommerce.com");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.navigate().back();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().refresh();
	}

}
