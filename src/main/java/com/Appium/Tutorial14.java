package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "realme 3 Pro");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.UDID, "159b3828");
		//cap.setCapability("noReset", "false");
		//cap.setCapability("automationName", "UiAutomator");
		cap.setCapability("appPackage","com.google.android.calendar");
	    cap.setCapability("appActivity","com.android.calendar.LaunchActivity");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		//driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void searchKeyword() throws InterruptedException
	{
		driver.findElementByName("q").sendKeys("appium");
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
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
