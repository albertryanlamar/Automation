package features.selfstudy.day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropdown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.hdfcbank.com/");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='drp1']//div[@class='dropdown'] | //div[@class='dropdown']"))).click();
        List<WebElement> drp = driver.findElements(By.xpath("//ul[contains(@class,'dropdown1 dropdown-menu')]/child::li | //ul[contains(@class,'dropdown1 dropdown-menu')]/li"));
      
       
       //1) select single value in dropdown
       // driver.findElement(By.xpath("//li[contains(text(),'Loans')]")).click();
        
       //2) capture the whole options and figure out the size
       //System.out.println("Number of Options in dropdown is: " + drp.size());
       
       //3) priting all options
        for(WebElement ad : drp) {
        	System.out.println(ad.getText());
       	 }
        //usinglambda expression
       // Click the matching element
       drp.forEach(el -> System.out.println(el.getText()));
       drp.stream()
          .filter(el -> el.getText().equalsIgnoreCase("Loans"))
          .findAny()
          .ifPresentOrElse(
        		  WebElement::click,
        		  () -> System.out.println("No matching item found: "));
     
       //using traditional java method
     /*  for(WebElement ad : drp) {
    	   System.out.println(ad.getText());
    	
       }
       for(WebElement ad : drp) {
    	 if(ad.getText().equalsIgnoreCase("Loans")) {
    		 ad.click();
    		 break;
    	 }
       } */
       
       //using tradional for loop
       for(int i=0;i<drp.size();i++ ) {
    	   String text = drp.get(i).getText();
    	    System.out.println(text);  // Print each value
    	   
    	   if(drp.get(i).getText().equalsIgnoreCase("Loans")) {
    		   drp.get(i).click();
    	   }       }
	
	}

}
