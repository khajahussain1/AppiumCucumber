/**
 * 
 */
package com.Appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//import org.apache.tools.ant.util.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
public class Tutorial20 {

	AppiumDriver<MobileElement> driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "HTC Desire 626 dual sim");
		cap.setCapability("appPackage", "com.android.mms");
		cap.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testAddContact() throws InterruptedException, IOException {
		try {
			TouchAction ac = new TouchAction(driver);
			MobileElement ele = driver.findElementById("com.android.mms:id/from");
			//ac.longPress(ele).perform().release();
			Thread.sleep(2000);
			boolean flag = driver.findElementById("com.android.mms:id/dele").isDisplayed();
			if (flag) {
				System.out.println("Passed");
			} else {
				System.out.println("Failed");
				getscreenshot(driver);
			}
		} catch (Exception e) {
			getscreenshot(driver);
		}

	}

	public void getscreenshot(AppiumDriver<MobileElement> d) throws IOException {
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String time = formater.format(date);
		File source = d.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "/Screenshot/" + time + ".png");

		//FileUtils.copyFile(source, destination);
		System.out.println("Screenshot is captured");
	}

	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	/*
	 * public static void main(String[] args) throws InterruptedException,
	 * IOException { // TODO Auto-generated method stub Tutorial20 obj = new
	 * Tutorial20(); obj.setUp(); obj.testAddContact(); obj.tearDown(); }
	 */

}
