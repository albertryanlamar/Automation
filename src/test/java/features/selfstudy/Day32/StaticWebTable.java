package features.selfstudy.Day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	
		
		//1) find the total row of the table
		List<WebElement> tr = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println("Total Row: "+ tr.size());
		
		//2) Count the number of column
		List<WebElement> th = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println("Total Column: "+ th.size());
		
		//3) Read all data from specific column BookName
		List<WebElement> thdata = driver.findElements(By.xpath("//table[@name='BookTable']//th[contains(text(),'BookName')]"));
		List<WebElement> trdata = driver.findElements(By.xpath("//table[@name='BookTable']//tr//td[1]"));
		System.out.println("Data in BookName Column are:");
		trdata.forEach(el->System.out.println(el.getText()));
		
		//4) Read specific data from specific Column
		String aa = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText(); 
	    System.out.println(aa);
	    
	    //5) Read data from all the row and column
	    System.out.println("Sample");
	    for(int row=2; row <= tr.size();row++) {
	    	for(int col=1; col<= th.size(); col++) {
	    		String val = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]//td["+col+"]")).getText();
	    		System.out.print(val+"\t");
	    	}
	    	System.out.println();
	    }
	    //using for each
	    System.out.println("Start of Traditional For each:");
	    for(WebElement r: tr.subList(1, tr.size())) {
	    	//List<WebElement> col = driver.findElements(By.xpath("//table[@name='BookTable']//tr["+rowin+"]//td"));
	    	List<WebElement> col = r.findElements(By.xpath(".//td"));
	    	for(WebElement c:col) {
	    		System.out.print(c.getText()+"\t");    		 
	    	}
	    	System.out.println();
	 
	    }
	    //using stream method
	    WebElement targetTable = driver.findElement(By.xpath("//table[@name='BookTable']"));
	    List<WebElement> rows = targetTable.findElements(By.xpath(".//tr"));
	    System.out.println("Start of Stream: ");
	    tr.stream()
	             .skip(1)
	             .forEach( ro ->{
	            		 List<WebElement> col = ro.findElements(By.xpath(".//td"));
                         col.stream()
                                  .forEach( cc -> 
                                	  System.out.print(cc.getText()+"\t")
                                	  	  );       
                         System.out.println();
                         });
	     
	  //6) Read the data or get the data whos author was Mukesh
	    System.out.println("Mukesh:");
	    int d =2;
	    for(WebElement r: tr.subList(1, tr.size())) {
	    	//List<WebElement> col = driver.findElements(By.xpath("//table[@name='BookTable']//tr["+rowin+"]//td"));
	    	List<WebElement> au = r.findElements(By.xpath(".//td[2]"));
	    	if(au.get(d).getText().equalsIgnoreCase("Mukesh")) {
	    		List<WebElement> col = r.findElements(By.xpath(".//td"));
	    		for(WebElement c:col) {
	    			System.out.print(c.getText()+"\t");    		 
	    		}
	    	}
	    	d++;
	    	System.out.println();
	    }
	    
	}
	
	
	

}
