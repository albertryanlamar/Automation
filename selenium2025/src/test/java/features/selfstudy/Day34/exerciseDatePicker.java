package features.selfstudy.Day34;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import io.github.bonigarcia.wdm.WebDriverManager;

public class exerciseDatePicker {

    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.get("https://dummy-tickets.com/buyticket");
        
        // Wait until the page fully loads (tab spinner stops)
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete")
        );
        
        
        // Now interact with the departure date input
    
        driver.findElement(By.xpath("//a[normalize-space()='Flight']"));
        driver.findElement(By.xpath("//input[@value='onewaymain']"));
        WebElement element = driver.findElement(By.xpath("//form[@id='flight_oneway']//input[contains(@placeholder,'Departure Date')]"));
        element.click();
    }
}