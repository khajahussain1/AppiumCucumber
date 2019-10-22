/**
 * 
 */
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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author CHIRAG
 *
 */
public class Tutorial22 {

	AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "HTC Desire 626 dual sim");
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/app/ApiDemos.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void tapAction()
	{
		// tap method using Appium driver
		MobileElement view = driver.findElementByAccessibilityId("Views");
		//driver.tap(1, view, 500);
		
		// tap method using Touch Action Class
		MobileElement autoComplete = driver.findElementByAccessibilityId("Auto Complete");
		//new TouchAction(driver).tap(autoComplete).perform().release();
		boolean flag = driver.findElementByAccessibilityId("1. Screen Top").isDisplayed();
		if(flag)
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	/*public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		Tutorial22 obj = new Tutorial22();
		obj.setUp();
		obj.tapAction();
		obj.tearDown();

	}
*/
}
