package features.selfstudy.day29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//1) handle normal alert with ok button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		
		Alert myalert = driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.accept();
		
		//2) Handle alert with two button ok and cancel
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(5000);
		
		//driver.switchTo().alert().accept();//close aler using OK button
		driver.switchTo().alert().dismiss();//click cancel button
	
       //Handle alert with textbox
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
	    Thread.sleep(5000);
	    
	    Alert myalert1 = driver.switchTo().alert();
	    myalert1.sendKeys("OK");
	    Thread.sleep(5000);
	    myalert1.accept();
	    
	}

}
