package features.selfstudy.Day33;

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

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://practice.expandtesting.com/dynamic-pagination-table?utm_source=chatgpt.com");
        List<WebElement> pageNoCount = driver.findElements(By.xpath("//ul//li[contains(@class,'paginate_button') and contains(@class,'page-item') and not(contains(@class,'previous')) and not(contains(@class,'next'))]"));
	    System.out.println(pageNoCount.size());
	    
	    for (int i = 0; i < pageNoCount.size(); i++) {
	        // re-locate to avoid stale element issue
	        List<WebElement> refreshedPages = driver.findElements(
	            By.xpath("//ul//li[contains(@class,'paginate_button') and contains(@class,'page-item') and not(contains(@class,'previous')) and not(contains(@class,'next'))]")
	        );

	        WebElement page = refreshedPages.get(i);
	        String pageText = page.getText(); // page number, e.g. "2", "3"
	        
	        if (!page.getAttribute("class").contains("active")) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", page);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", page);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr")));
	        }
	        System.out.println("Clicked page: " + pageText);
	        
	        //get all the value in the table per page
            List<WebElement> tr = driver.findElements(By.xpath("//table[@id='example']//tr"));
            //List<WebElement> col = driver.findElements(By.xpath("//table[@id='example']//th"));
            
            for(WebElement r: tr .subList(1, tr.size())) {
            	List<WebElement> col = r.findElements(By.xpath(".//td"));
            	for(WebElement c:col) {
    	    		System.out.print(c.getText()+"\t");    		 
    	    	}
    	    	System.out.println();
            }
	        
	    }
	    

	}

}
