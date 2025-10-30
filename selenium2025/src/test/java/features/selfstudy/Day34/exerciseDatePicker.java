package features.selfstudy.Day34;

import java.time.Duration;
import java.time.Year;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class exerciseDatePicker {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://dummy-tickets.com/buyticket");

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));

        // open the datepicker
        driver.findElement(By.xpath("//a[normalize-space()='Flight']")).click();
        driver.findElement(By.xpath("//input[@value='onewaymain']")).click();
        WebElement element = driver.findElement(
                By.xpath("//form[@id='flight_oneway']//input[contains(@placeholder,'Departure Date')]"));
        element.click();

        String targetYearText = "2022";
        Year targetYear = Year.of(Integer.parseInt(targetYearText));
        boolean found = false;

        while (!found) { // max 20 loops to avoid infinite
            List<WebElement> yearDropdown = driver.findElements(By.xpath("//select[@class='ui-datepicker-year']//option"));
            
         // Step 1: check if target year is in options
            for (WebElement option : yearDropdown) {
                if (option.getText().equals(targetYearText)) {
                    option.click();
                    System.out.println("✅ Target year selected: " + targetYearText);
                    found = true;
                    break;
                }
            }
            
            // Step 2: if not found, click Previous (or Next depending on target)
            if (!found) {
            	String currentYearText = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']/option[@selected='selected']")).getText();
                Year currentYear = Year.of(Integer.parseInt(currentYearText));
                if (targetYear.isBefore(currentYear)) {
                    driver.findElement(By.xpath("//a[@title='Prev']")).click();
                } //else {
                   // driver.findElement(By.xpath("//a[@title='Next']")).click();
                //}
                Thread.sleep(500); // wait for dropdown to refresh
            }
            
        }
        
    }
}