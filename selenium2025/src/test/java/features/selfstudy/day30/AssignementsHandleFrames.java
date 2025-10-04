package features.selfstudy.day30;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignementsHandleFrames {

	public static void main(String[] args) throws Exception {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		
		//frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frameset[1]/frame[1]"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("TestFrame1");
		driver.switchTo().defaultContent();
		
		//frame 2
		WebElement frame2 = driver.findElement(By.xpath("//frameset//frameset//frame[1]"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("aa");
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
         driver.switchTo().defaultContent();
         
         //frame 5
         
		WebElement frame5 = driver.findElement(By.xpath("//frame[contains(@src,'frame_5.html')] | //frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//input[@name='mytext5'] | //input[contains(@name,'mytext5')]")).sendKeys("Frame 5");
		
		WebElement link = driver.findElement(By.xpath("//a[@href='https://a9t9.com'] | //a[contains(text(),'https://a9t9.com')]"));
	
	    js.executeScript("arguments[0].click()", link);
        
	    //WebElement img = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation'] | //img[contains(@alt,'Ui.Vision')]")));
	    Thread.sleep(1000);
	    WebElement img = driver.findElement(By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation'] | //img[contains(@alt,'Ui.Vision')]"));
	    System.out.println("Image was found " + img.isDisplayed());
	}

}
