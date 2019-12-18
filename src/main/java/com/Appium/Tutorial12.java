/**
 * 
 */
package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Tutorial12 {

	AppiumDriver<MobileElement> driver;
	String path;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		System.out.println("Session is creating");
		//System.gc();
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "realme 3 Pro");
		cap.setCapability("platformVersion", "9");
		//cap.setCapability("automationName", "UiAutomator");
		cap.setCapability("udid", "159b3828");
		 cap.setCapability("skipUnlock","true");
		//cap.setCapability("noReset", "false");
		cap.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/app/ApiDemos.apk");
		
		try {
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url, cap);
		
		}catch(MalformedURLException e) {
			System.out.println(e.getMessage());
			
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Session is created");
		
		
		
	}

	@Test
	public void clickTab() {
		boolean flag = false;
		driver.findElementByAccessibilityId("Views").click();
		for (int i = 0; i <= 20; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			   
			    
			   
				 MobileElement element = driver.findElementByAccessibilityId("Tabs");
				
			    element.click();
				
				
				break;
			} catch (Exception e) {
				verticalSwipe();
			}
		}
		flag = driver.findElementByAccessibilityId("1. Content By Id").isDisplayed();
		if (flag) {
			System.out.println("Passed");
			System.out.println(flag);
		} else {
			System.out.println("Failed");
		}
	}

	public void verticalSwipe() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
			HashMap<String, String> swipeObject = new HashMap<String, String>();
			swipeObject.put("direction", "up");
			swipeObject.put("startX", "120");
			swipeObject.put("startY", "650");
			swipeObject.put("endX", "120");
			swipeObject.put("endY", "35");
			swipeObject.put("duration", "1.8");
			js.executeScript("mobile: swipe", swipeObject);  //FAILS
			js.executeScript("mobile: scroll", swipeObject); //FAILS
		MobileElement element = driver.findElementByAccessibilityId("Tabs");
		/*TouchActions action = new TouchActions(driver);
		action.scroll(element, 10, 100);
		action.perform();*/
		
		/*Dimension size = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int starty = (int) (height * 0.80);
		int endy = (int) (height * 0.20);
		
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		driver.swipe(startx, endy, startx, starty, 3000);*/
		
		/*Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int starty = (int) (height * 0.80);
		int endy = (int) (height * 0.20);
		driver.swipe(x, starty, x, endy, 500);
*/
	}

	@AfterMethod
	public void teardown() {
		//driver.quit();
	}

	
}
