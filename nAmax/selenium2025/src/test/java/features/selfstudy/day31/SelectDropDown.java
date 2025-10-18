package features.selfstudy.day31;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement drpCountry = driver.findElement(By.xpath("//select[@id='country']"));
		Select drp= new Select(drpCountry);
		
		//select option from the drop down
		
		//drp.selectByVisibleText("France");
		//drp.selectByValue("japan");
		//drp.selectByIndex(2);
		List<WebElement> options = drp.getOptions();
		System.out.println("Number of list on the dropdown " + options.size());
		
		/* 
		for(int i=0;i<options.size();i++){
		options.get(i).getText();
		}
		*/
		//enhanced loop
		for(WebElement aa:options) {
			System.out.println(aa.getText());
		}
	}

}
