	package features.selfstudy.Day33;
	
	import org.openqa.selenium.chrome.ChromeDriver;
	
	import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	
	public class exerciseDynamicTable {

	    public static void main(String[] args) throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	        driver.get("https://testautomationpractice.blogspot.com/");
	        driver.manage().window().maximize();

	        // get total number of pages
	        int totalPages = driver.findElements(By.xpath("//ul[@id='pagination']//li//a")).size();
	        System.out.println("Total pages: " + totalPages);

	        for (int i = 0; i < totalPages; i++) {
	            // refresh pagination links every loop
	            List<WebElement> refreshedPages = driver.findElements(By.xpath("//ul[@id='pagination']//li//a"));
	            WebElement currentPage = refreshedPages.get(i);
	            String pageText = currentPage.getText();

	            // if not active, click the page
	            if (!currentPage.getAttribute("class").contains("active")) {
	                currentPage.click();
	                Thread.sleep(1000); // wait for table to refresh
	            }

	            System.out.println("===== Page " + pageText + " =====");

	            // get table rows
	            List<WebElement> tr = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));

	            for (WebElement row : tr) {
	                List<WebElement> cols = row.findElements(By.xpath(".//td"));
	                for (WebElement col : cols) {
	                    System.out.print(col.getText() + "\t");
	                }
	                System.out.println();
	            }

	            // click all checkboxes in column 4
	            List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr//td[4]//input"));
	            for (WebElement cb : checkboxes) {
	                if (!cb.isSelected()) {
	                    cb.click();
	                }
	            }
	        }
	    }
	}