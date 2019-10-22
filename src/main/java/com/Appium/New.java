package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class New {
	
	AppiumDriver<MobileElement> driver;
	
	@Test
	public void test()
	{
		System.out.println("Session is creating");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "realme 3 Pro");
		cap.setCapability("platformVersion", "9");
		//cap.setCapability("automationName", "UiAutomator");
		cap.setCapability("udid", "159b3828");
		//cap.setCapability("--noReset--", "false");
		cap.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/app/ApiDemos.apk");
		
		try {
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url, cap);
		
		}catch(MalformedURLException e) {
			System.out.println(e.getMessage());
			
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Session is created");
		
		driver.findElementByAccessibilityId("Views").click();
		
		MobileElement element = driver.findElementByAccessibilityId("Tabs");
		
		TouchActions action = new TouchActions(driver);
		/*action.scroll(element, 10, 100);
		action.perform();*/
		
		
		 
		 
		//{elementId, elementToId}	{elementId: 2, elementToId: 1}
	}

}
