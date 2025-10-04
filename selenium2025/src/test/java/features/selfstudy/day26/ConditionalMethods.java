package features.selfstudy.day26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/register");
		
		//isDisplayed()
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
        System.out.println("Display status of logo:" + logo.isDisplayed());
        
        boolean aa = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
        System.out.println("Display status of logo:" + aa);
        
        //isEnabled()
        boolean isEnableStat = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
        System.out.println("Display status of logo:" + isEnableStat);	
        Thread.sleep(5000);
        //individual finding of radio button
       WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
       WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));
        
        System.out.println("Before Selection....................");
        System.out.println(male.isSelected());
        System.out.println(female.isSelected());
        
        System.out.println("After Selecting Male....................");
        male.click();
        System.out.println(male.isSelected());
        System.out.println(female.isSelected());
        
        //System.out.println("After Selecting Female....................");
        //female.click();
        //System.out.println(male.isSelected());
        //System.out.println(female.isSelected());
       
        //search all radio button
       List<WebElement> rdarios =  driver.findElements(By.xpath("//div[@id='gender']//input[@type='radio']"));
	for(WebElement rd:rdarios) {
		WebElement sg = driver.findElement(By.xpath("//label[@for='"+rd.getAttribute("id")+"']"));
		if(!rd.isSelected()) {
			
			System.out.println(sg.getText()+" All Radio button is not selected");
		}
		if(rd.isSelected()) {
			System.out.println(sg.getText()+ "is selected");
		}
	}
	
	}

}
