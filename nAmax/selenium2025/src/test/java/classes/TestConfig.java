package classes;

import java.net.MalformedURLException;

import utility.Constant;
import utility.LaunchApp;

public class TestConfig {
	
	private String platform = null;
	private String browser = null;
	private String runIn = null;

	
	
	public enum OPTIONS{	
		DESKTOP_LOCAL_CHROME,
		DESKTOP_SAFARI,
		DESKTOP_LOCAL_FIREFOX,
		DESKTOP_LOCAL_EDGE,
		DESKTOP_CHROME,
		DESKTOP_FIREFOX,
		DESKTOP_EDGE,
		DESKTOP_IE,
		ANDROID_LOCAL_CHROME,
		ANDROID_LOCAL_FIREFOX,
		ANDROID_LOCAL_EDGE,
		ANDROID_PERFECTO_CHROME,
		IOS_PERFECTO_SAFARI,
		IOS_PERFECTO_CHROME,
		ANDROID_LOCAL_HYBRID,
		ANDROID_PERFECTO_HYBRID,
		IOS_PERFECTO_HYBRID,
		ANDROID_LOCAL_NATIVE,
		ANDROID_PERFECTO_NATIVE,
		IOS_PERFECTO_NATIVE,
		DESKTOP_LAMBDA_CHROME,DESKTOP_LAMBDA_SAFARI,DESKTOP_LAMBDA_EDGE,DESKTOP_LAMBDA_FIREFOX,
		DESKTOP_TESTINGBOT_CHROME,
		ANDROID_LAMBDA_CHROME,
		IOS_LAMBDA_SAFARI;
	}
	
	public void setPlatformConfigTo(OPTIONS opt) throws Exception
	{
		/*^^^^^^^Setting a platform^^^^^^^^*/
		String opts = opt.name();
		
		if(opts.contains("DESKTOP_LOCAL")) 
		{
		 this.platform = "Desktop_Local";
		}
		else if(opts.contains("IOS")) 
		{
		 this.platform = "IOS";
		}
		else if(opts.contains("ANDROID")) {
		 this.platform = "Android";
		}
		else {
			this.platform = "Desktop";
		}
		Constant.Platform = this.platform;
		/*^^^^^^^END Setting a platform^^^^^^^^*/
		
		/*####### Configure a browser ######*/
		if(opts.contains("CHROME")) {
			this.browser = "Chrome";
		}
		else if(opts.contains("EDGE")) {
			this.browser = "Edge";
		}
		else if(opts.contains("FIREFOX")) {
			this.browser = "Firefox";
		}
		else {
			this.browser="Safari";
		}
		Constant.Browser = this.browser;
		/*####### END of Configure a browser ######*/
		
		/*####### Configure a run IN ######*/
		if(opts.contains("LAMBDA")) {
			this.runIn = "Lambda";
		}
		else if(opts.contains("PERFECTO")) {
			this.runIn = "Perfecto";
		}
		else if(opts.contains("BROWSERSTACK")) {
			this.runIn = "BrowserStack";
		}
		else if(opts.contains("SOURCELAB")) {
			this.runIn = "Sourcelab";
		}
		else if(opts.contains("TESTINGBOT")) {
			this.runIn = "Testingbot";
		}
		else if(opts.contains("BROWSERSTACK")) {
			this.runIn = "Browserstack";
		}
		else {
			this.runIn = "Desktop";
		}
		Constant.RunIn = this.runIn;
		/*####### END of Configure Run IN ######*/
		
		if(this.runIn.equalsIgnoreCase("Lambda")) {
			if(opts.contains("CHROME")) {
				LaunchApp.LambdaSetup("Chrome");
			}
		}
		if(this.runIn.equalsIgnoreCase("Testingbot")) {
			
			LaunchApp.TestingbotSetup(this.browser);
		}
		
	}

}
