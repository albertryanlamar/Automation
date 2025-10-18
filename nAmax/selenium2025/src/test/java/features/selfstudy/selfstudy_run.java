package features.selfstudy;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import classes.TestConfig;
import classes.TestConfig.OPTIONS;
import utility.Constant;

public class selfstudy_run {
	
	TestConfig a = new TestConfig();
	
	@Test
	public void selfstudy() throws Exception {
		a.setPlatformConfigTo(OPTIONS.DESKTOP_TESTINGBOT_CHROME);
		Constant.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Constant.driver.get("https://testautomationpractice.blogspot.com/");
		
		
		WebElement searchbox = Constant.driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
        if(searchbox!=null) {
        	searchbox.sendKeys("hi");
        	 System.out.println("Able to input in Searbox: Pass");	
        }
        
        WebElement clickSearch = Constant.driver.findElement(By.xpath("//input[@type='submit']"));
        if(clickSearch !=null) {
        	clickSearch.click();
        	 System.out.println("Able to Click Search: Pass");	
        }
        
        List<WebElement> resultLists = Constant.driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']//a"));
        
        System.out.println("Result Count is: "+ resultLists.size());
        
  
        	for(WebElement aa: resultLists) {
        		aa.click();
        		System.out.println("Able to click: Pass "+ aa.getText());
        	}

        	Set<String> windowIDS = Constant.driver.getWindowHandles();
        	String[] windowArray = windowIDS.toArray(new String[0]);
        	System.out.println("Able to click: Pass "+ windowIDS);
        	
        	for(String dis:windowArray) {
               if(dis.equals(windowArray[1])) {
            	   Constant.driver.switchTo().window(dis);
            	   Constant.driver.close();
               }
               if(dis.equals(windowArray[2])) {
            	   Constant.driver.switchTo().window(dis);
            	   Constant.driver.close();
               }
        	}
	}
	

	

}
