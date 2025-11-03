package features.selfstudy.Day35;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import classes.TestConfig;
import classes.TestConfig.OPTIONS;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constant;

public class mouseActions {

	public static void main(String[] args) throws Exception {
		TestConfig a = new TestConfig();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.manage().window().maximize();
	    
		
		//
		WebElement aa=null, bb = null;
		Actions act = new Actions(driver);
		// mouse hover
		act.moveToElement(aa).moveToElement(bb).perform();
		act.moveToElement(bb).click().build().perform();
		act.moveToElement(bb).click().perform();
	

	}

}
