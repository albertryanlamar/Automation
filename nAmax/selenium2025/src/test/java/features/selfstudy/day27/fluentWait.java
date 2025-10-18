package features.selfstudy.day27;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fluentWait 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();// pede wala na
		WebDriver driv = new ChromeDriver();
		
		//fluent wait declaration
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driv)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);

		
		driv.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driv.manage().window().maximize();

		
		   WebElement uname = mywait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.xpath("//input[@placeholder='Username']"));
			     } 
		   });
		   
		
		//WebElement elemnetwa = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		//elemnetwa.sendKeys("aa");
		
		//WebElement pass =  mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		//pass.sendKeys("aa");
		
		//WebElement btn = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
		//WebElement btn = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		//btn.click();

	}

}
