package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Tutorial13 {

	// AppiumDriver<MobileElement> driver;
	AndroidDriver<MobileElement> driver;
	String path;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		// System.out.println("Session is creating");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "HTC Desire 626 dual sim");
		cap.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/app/ApiDemos.apk");
		URL url = new URL("http://217.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// System.out.println("Session is created");
		
	}

	@Test
	public void clickTab() {
		boolean flag = false;
		driver.findElementByAccessibilityId("Views").click();
		for (int i = 0; i <= 20; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				driver.findElementByAccessibilityId("Tabs").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				break;
			} catch (Exception e) {
				verticalSwipe();
			}
		}
		driver.findElementByAccessibilityId("5. Scrollable").click();
		verifyTab28();
	}

	public void verifyTab28() {
		boolean f = false;
		for (int i = 1; i <= 10; i++) {
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				f = driver.findElementByXPath("//*[@text='TAB 30']").isDisplayed();

				f = true;
				break;
			} catch (Exception e) {
				hortizonalSwipe();
			}
		}
		if (f) {
			System.out.println("Passed");
		} else {
			System.out.println(f);
			System.out.println("Failed");
		}

	}

	public void hortizonalSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int) (height * 0.20);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);
		//driver.scroll(startx, y, endx, y, 500);
	}

	public void verticalSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int starty = (int) (height * 0.80);
		int endy = (int) (height * 0.20);
		//driver.swipe(x, starty, x, endy, 500);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
