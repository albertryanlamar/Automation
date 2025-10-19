package features.selfstudy.day30;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//switch to frame using webelement
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Test");
		
        driver.switchTo().defaultContent();//go back to page
        
        //frame2
		WebElement frame2 = driver.findElement(By.xpath("//frameset//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Test2");
        
        driver.switchTo().defaultContent();
        
        //frame 3
        
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
       driver.switchTo().frame(frame3);
       driver.findElement(By.xpath(" //input[@name='mytext3']")).sendKeys("aa");
        
       	//inner frame
         	
         	driver.switchTo().frame(0);// 1) using index since iframe is only one.
         	WebElement aaa = driver.findElement(By.xpath("//div[@id='i6']//div[@class='AB7Lab Id5V1']"));
         	
         	JavascriptExecutor js  = (JavascriptExecutor) driver;
         	js.executeScript("arguments[0].click()", aaa);
         	
         	driver.switchTo().defaultContent();
         	
         	
         //frame 4
         WebElement frame4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));  	
         driver.switchTo().frame(frame4);
         driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("aaaaa");
       
        
	}

}
