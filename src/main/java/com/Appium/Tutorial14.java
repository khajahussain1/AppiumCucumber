package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class Tutorial14 {

	AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "realme 3 Pro");
		caps.setCapability("udid", "159b3828"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("browserName", "Chrome");
		//caps.setCapability("noReset", true);
		//System.setProperty("webdriver.chrome.driver",System.getProperty("usr.dir")+"/libs/chromedriver.exe");
		//URL url = new URL("http://0.0.0.0:4723/wd/hub");
		//AppiumDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			String sessionId = driver.getSessionId().toString();
			System.out.println("sessionId:-"+sessionId);


			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		//driver = new AndroidDriver<MobileElement>(url, caps);
		//driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.get("http://www.google.com");
		
		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "realme 3 Pro");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.UDID, "159b3828");
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("androidPackage", "com.android.chrome");
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		//cap.setCapability("noReset", "false");
		//cap.setCapability("automationName", "UiAutomator");
		//cap.setCapability("appPackage","com.google.android.calendar");
	    //cap.setCapability("appActivity","com.android.calendar.LaunchActivity");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		//driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		//driver.get("http://www.yahoo.com");
*/	}
	
	@Test
	public void searchKeyword() throws InterruptedException
	{
		//driver.findElementByName("q").sendKeys("appium");
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
	/**
	 * @param args
	 * @throws MalformedURLException 
	 * @throws InterruptedException 
	 */
//	public static void main(String[] args) throws MalformedURLException, InterruptedException {
//		Tutorial14 obj = new Tutorial14();
//		obj.setUp();
//		obj.searchKeyword();
//		obj.tearDown();
//
//	}

}
