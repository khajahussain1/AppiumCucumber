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
import io.appium.java_client.android.AndroidDriver;

public class Tutorial6 {

	AppiumDriver<MobileElement> driver;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		System.out.println("Session is creating");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "HTC Desire 626 dual sim");

		cap.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/app/ApiDemos.apk");
		System.out.println(System.getProperty("user.dir") + "/src/test/resources/app/ApiDemos.apk");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String sessionId = driver.getSessionId().toString();
		System.out.println("sessionId"+sessionId);
		System.out.println("Session is created");
	}

	@Test
	public void validateText() {
		driver.findElementByAccessibilityId("Accessibility").click();
		String text = driver.findElementByAccessibilityId("Accessibility Node Provider").getText();
		if (text.equalsIgnoreCase("Accessibility Node Provider")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

	 @AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
