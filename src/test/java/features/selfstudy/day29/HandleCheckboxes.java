package features.selfstudy.day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckboxes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//select specific check box
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();

		//select all checkboxes
		List<WebElement> daylist = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
	    System.out.println(daylist.size());
	    //using foreachlop
	    for(WebElement lst:daylist) {
	    	lst.click();
	    	System.out.println(lst.getAttribute("value")+" is selected: "+lst.isSelected());
	    }
	    
	    //using for loop to uncheck all checkboxes
	    for(int i=0;i<daylist.size();i++) {
	    	
	    daylist.get(i).click();
	    System.out.println(daylist.get(i).getAttribute("value")+ " is selected: "+ daylist.get(i).isSelected());
	    }
	    
	    //3) seelct last 3 checkboxes
	    //7-3 = 4
	    for(int i=4;i<daylist.size();i++) {
	    	daylist.get(i).click();
	    }
	    
	    //4) select firt 3 checkboxes
	    for(int i=4;i<3;i++) {
	    	daylist.get(i).click();
	    }
	    
	    //unselect check boxes that are selected
	    for(WebElement lst:daylist) {
	    	if(lst.isSelected()) {
	    		lst.click();
	    		System.out.println(lst.getAttribute("value")+" is unselected: "+lst.isSelected());
	    	}
	    }
	}

}
