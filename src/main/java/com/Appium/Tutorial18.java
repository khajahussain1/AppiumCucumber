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

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author CHIRAG
 *
 */
public class Tutorial18 {

	AndroidDriver<MobileElement> driver;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 9");
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "//app//ApiDemos.apk");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
    
	@Test
	public void handleAutoCompleteDropdown() throws InterruptedException {
		driver.findElementByAccessibilityId("Views").click();
		driver.findElementByAccessibilityId("Auto Complete").click();
		driver.findElementByAccessibilityId("1. Screen Top").click();
		driver.findElementById("io.appium.android.apis:id/edit").sendKeys("india");
		Thread.sleep(2000);
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
		Thread.sleep(2000);
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
		Thread.sleep(2000);
		//driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(2000);
		String text = driver.findElementById("io.appium.android.apis:id/edit").getText();
		System.out.println("Text Found : " + text);
		if (text.equals("India")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	/**
	 * @param args
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	/*public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		Tutorial18 obj = new Tutorial18();
		obj.setup();
		obj.handleAutoCompleteDropdown();
		obj.tearDown();
	}*/

}
