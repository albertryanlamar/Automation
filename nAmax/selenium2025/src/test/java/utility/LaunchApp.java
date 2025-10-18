package utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.android.AndroidDriver;

public class LaunchApp {
	String platform = "";
    public static String  username = Constant.SAUCE_USERNAME;
    public static String accessKey = Constant.SAUCE_ACCESS_KEY;
    public static String tb_key = Constant.TBKEY;
    public static String tb_secret = Constant.TBSECRET;
	public static final String GRID_URL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
	public static final String TGRID_URL = "https://"+ tb_key +":"+ tb_secret +"@hub.testingbot.com/wd/hub";
	public static final String BGRID_URL = "https://"+ tb_key +":"+ tb_secret +"@hub.testingbot.com/wd/hub";
	static MutableCapabilities multioption = new MutableCapabilities();
	static DesiredCapabilities caps = new DesiredCapabilities();
	
	//For Sauce Labs Setup
	public static void SourcelabSetup(String Browser) 
	{
		if(Constant.Platform.equalsIgnoreCase("Android")) 
		{
			Constant.driver = startSourceLab_Android();
		}
	}
	// For LambdaSetup
	public static void LambdaSetup(String Browser) throws Exception {
		if(Constant.Platform.equalsIgnoreCase("Android")) 
		{
			Constant.driver = startLambda_Android();
		}
		if(Constant.Platform.equalsIgnoreCase("Ios")) 
		{
			Constant.driver = startLambda_IOS();
		}
		else {
			Constant.driver = startLambda_Desktop(Browser);
		}
	}
	// For Testingbot Setup
	public static void TestingbotSetup(String Browser) throws Exception {
		if(Constant.Platform.equalsIgnoreCase("Android")) 
		{
			Constant.driver = startLambda_Android();
		}
		if(Constant.Platform.equalsIgnoreCase("Ios")) 
		{
			Constant.driver = startLambda_IOS();
		}
		else {
			Constant.driver = startTestingbot_Desktop(Browser);
		}
	}
	// Testingbot for Android setup
	public static RemoteWebDriver startTestingbot_Desktop( String Browser) {
		if(Browser.equalsIgnoreCase("Chrome")) {
			multioption.setCapability("build", "My First Build");
			multioption.setCapability("name", "Albert");
			multioption.setCapability("screenshots",true);
			multioption.setCapability("video", true);
			multioption.setCapability("idleTimeout", 300);
		
	    // Create browser capabilities
	    //ChromeOptions browserOptions = new ChromeOptions();
	    caps.setCapability("browserName", "Chrome");
	    caps.setCapability("browserVersion", "121.0");
	    caps.setCapability("platformName", "Windows 10");
	    caps.setCapability("LT:Options", multioption);
	    
	    	try 
	    	{
	    		Constant.driver = new RemoteWebDriver(new URL(TGRID_URL), caps);
	    	}
	    	catch(Exception e){
	    	e.printStackTrace();
	    	}
		}
		
		return Constant.driver;
	}
	
	// Android Lambda Setup
	public static AndroidDriver startLambda_Android() 
	{
        // Target mobile browser (Chrome on Android)
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Samsung Galaxy S22.*"); // You can use regex
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("name", "Android Web App Test");
        
        try {
            URL url = new URL(GRID_URL);
            return new AndroidDriver(url, caps);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		
	}
	
	public static AndroidDriver startLambda_IOS() 
	{
        // Target mobile browser (Chrome on Android)
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Samsung Galaxy S22.*"); // You can use regex
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("name", "Android Web App Test");
        
        try {

        	URL url = new URL(GRID_URL);
            return new AndroidDriver(url, caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
		
	}
	
	//for browserstack
	public static  RemoteWebDriver startBrowserstark(String Browser) throws Exception {
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			multioption.setCapability("build", "Selfstudy_DryRun");
			multioption.setCapability("name", "Selfstudy_DryRun");
			
		    // Create browser capabilities
		    caps.setCapability("browserName", "Chrome");
		    caps.setCapability("browserVersion", "121.0");
		    caps.setCapability("platformName", "Windows 10");
		    caps.setCapability("LT:Options", multioption);
		    
		    Constant.driver = new RemoteWebDriver(new URL(BGRID_URL),caps);
		}
		
		
		return Constant.driver;
	}
	
	public static RemoteWebDriver startLambda_Desktop(String Browser) throws MalformedURLException 
	{	
		if(!(Browser==null)) 
		{			
			if(Browser.equalsIgnoreCase("Chrome")) 
			{    
				 // Create multi Options and put LambdaTest-specific capabilities
				multioption.setCapability("build", "SelfyStudy_DryRun");
				multioption.setCapability("name", "SelfyStudy_Chrome");
				multioption.setCapability("idleTimeout", 360);
				multioption.setCapability("console", true);
				multioption.setCapability("network", true);
				multioption.setCapability("video", true);
				multioption.setCapability("visual", true);

			    // Create browser capabilities
			    //ChromeOptions browserOptions = new ChromeOptions();
			    caps.setCapability("browserName", "Chrome");
			    caps.setCapability("browserVersion", "121.0");
			    caps.setCapability("platformName", "Windows 10");
			    caps.setCapability("LT:Options", multioption);
				try 
				{
					
					Constant.driver = new RemoteWebDriver(new URL(GRID_URL), caps);
				} 
				catch (MalformedURLException e) 
				{
					e.printStackTrace();
					Constant.driver = null;
			    }
        
			}
			if(Browser.equalsIgnoreCase("Edge")) 
			{
				// Target  browser (Chrome on Desktop)
				caps.setCapability("browserName", "Edge");
				caps.setCapability("browserVersion", "latest");
				caps.setCapability("platformName", "Windows 11");
				caps.setCapability("name", "My Edge Lambda Test");
				try {
					Constant.driver = new RemoteWebDriver(new URL(GRID_URL), caps);
				}
				catch(Exception e) {
					e.printStackTrace();
					Constant.driver = null;
				}
			}
			
		}
		else 
		{
			
		}
		return Constant.driver;
		
	}
	
	public static AndroidDriver startSourceLab_Android() 
	{
        DesiredCapabilities caps = new DesiredCapabilities();
        // Target mobile browser (Chrome on Android)
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Samsung Galaxy S22.*"); // You can use regex
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("name", "Android Web App Test");
        
        try {
            String username = Constant.SAUCE_USERNAME;
            String accessKey = Constant.SAUCE_ACCESS_KEY;
            URL url = new URL("https://" + username + ":" + accessKey + "@ondemand.saucelabs.com:443/wd/hub");
            return new AndroidDriver(url, caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
		
	}

}
