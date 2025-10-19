package features.selfstudy.day29;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentsHandleCheckbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//List<WebElement> chcklist = driver.findElements(By.xpath("//table//tr/td[last()]/input[@type='checkbox']"));
		
		//System.out.println("Check how many of checkboxes: " + chcklist.size());
		
		//select all unselected checkbox
		/*for(WebElement a : chcklist) {
			if(!a.isSelected()) {
				a.click();
			}
		} */
		
		//click checbox based on the value on the table
		
		List<WebElement> chcklst = driver.findElements(By.xpath("//table[contains(@id, 'productTable')]//tr"));
		if(!chcklst.isEmpty()) {
		for(WebElement row:chcklst) {
			
			String productname = row.findElement(By.xpath("//table[contains(@id,'productTable')]//tr//td[2]")).getText();
			System.out.println(productname);
			
			if(productname.equalsIgnoreCase("Smartphone")) {
				
				WebElement chckrow = row.findElement(By.xpath("//td[last()]/input[@type='checkbox']"));
				if(!chckrow.isSelected()) {
					chckrow.click();
				}
				break;
			}
			else {
				System.out.println("Error");
			}
		}
		}

	}

}
