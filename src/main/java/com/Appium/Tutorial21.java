/**
 * 
 */
package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author CHIRAG
 *
 */
public class Tutorial21 {

	AppiumDriver<MobileElement> driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "HTC Desire 626 dual sim");
		cap.setCapability("appPackage", "com.android.mms");
		cap.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testRotate()
	{
		if(driver.getOrientation().equals("LANDSCAPE"))
		{
			switchtomode("PORTRAIT");
		}else
		{
			switchtomode("LANDSCAPE");
		}
		
	}
	
	public void switchtomode(String modeType)
	{
		ScreenOrientation currentOrientation = driver.getOrientation();
		System.out.println("CurrentOrientation : "+currentOrientation);
		if(modeType.equalsIgnoreCase("LANDSCAPE"))
		driver.rotate(ScreenOrientation.LANDSCAPE);
		else if(modeType.equalsIgnoreCase("PORTRAIT"))
		{
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		currentOrientation = driver.getOrientation();
		System.out.println("AfterRotate : "+currentOrientation);
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
		Tutorial21 obj = new Tutorial21();
		obj.setUp();
		obj.testRotate();
		obj.tearDown();
	}*/

}
