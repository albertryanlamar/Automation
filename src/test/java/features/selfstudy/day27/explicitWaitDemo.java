package features.selfstudy.day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class explicitWaitDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();// pede wala na
		WebDriver driv = new ChromeDriver();
		WebDriverWait mywait = new WebDriverWait(driv,Duration.ofSeconds(30));// declarion of explicitwait
		
		driv.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driv.manage().window().maximize();

		WebElement elemnetwa = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		elemnetwa.sendKeys("aa");
		
		WebElement pass =  mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		pass.sendKeys("aa");
		
		//WebElement btn = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
		WebElement btn = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		btn.click();
		
		
		
	}

}
