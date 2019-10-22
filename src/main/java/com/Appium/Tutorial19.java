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

/**
 * @author CHIRAG
 *
 */
public class Tutorial19 {

	AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		//driver.startActivity("com.android.mms", "com.android.mms.ui.ConversationList");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "HTC Desire 626 dual sim");
		cap.setCapability("appPackage", "com.android.mms");
		cap.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void longPress() throws InterruptedException
	{
		TouchAction ac = new TouchAction(driver);
		MobileElement ele = driver.findElementById("com.android.mms:id/from");
		//ac.longPress(ele).perform().release();
		Thread.sleep(2000);
		boolean flag = driver.findElementById("com.android.mms:id/delete").isDisplayed();
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
	 * @throws InterruptedException 
	 */
	/*public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		Tutorial19 obj = new Tutorial19();
		obj.setUp();
		obj.longPress();
		obj.tearDown();
	}*/

}
