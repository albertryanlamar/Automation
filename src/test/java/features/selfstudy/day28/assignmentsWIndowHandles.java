package features.selfstudy.day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignmentsWIndowHandles {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
        if(searchbox!=null) {
        	searchbox.sendKeys("hi");
        	 System.out.println("Able to input in Searbox: Pass");	
        }
        
        WebElement clickSearch = driver.findElement(By.xpath("//input[@type='submit']"));
        if(clickSearch !=null) {
        	clickSearch.click();
        	 System.out.println("Able to Click Search: Pass");	
        }
        
        List<WebElement> resultLists = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));
        
        System.out.println("Result Count is: "+ resultLists.size());
        
  
        	for(WebElement aa: resultLists) {
        		aa.click();
        		System.out.println("Able to click: Pass "+ aa.getText());
        	}

        	Set<String> windowIDS = driver.getWindowHandles();
        	String[] windowArray = windowIDS.toArray(new String[0]);
        	System.out.println("Able to click: Pass "+ windowIDS);
        	
        	for(String dis:windowArray) {
               if(dis.equals(windowArray[1])) {
            	   driver.switchTo().window(dis);
            	   driver.close();
               }
               if(dis.equals(windowArray[2])) {
            	   driver.switchTo().window(dis);
            	   driver.close();
               }
        	}
        	
        	
	}

}
