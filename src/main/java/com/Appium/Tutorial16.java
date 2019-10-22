/**
 * 
 */
package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
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
public class Tutorial16 {

	AppiumDriver<MobileElement> driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		System.out.println("Session is creating");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "4.4.4");
		cap.setCapability("deviceName", "HTC Desire 626 dual sim");
		cap.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/app/ApiDemos.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Session is created");
	}

	@Test
	public void getWebViewText() {
		
		System.out.println("First Current Context : " + driver.getContext());
		
		driver.findElementByAccessibilityId("Views").click();
		
		for (int i = 0; i <= 20; i++) {
			
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				
				driver.findElementByAccessibilityId("WebView").click();
				
				break;
				
			} catch (Exception e) {
				
				verticalSwipe();
			}
		}
		
		// Using this method we switch to web view
		
		switchContext("WEBVIEW");
		
		 String webViewText = driver.findElementByXPath("//a[text()='Hello World! - 1']").getText();

		String webViewText1 = driver.findElementByXPath("//android.webkit.WebView[@index='0']").getText();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		System.out.println(webViewText);
		
		System.out.println(webViewText1);
		
		System.out.println("welcome to hyd");

	}

	/**
	 // assuming we have a set of capabilities
driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

Set<String> contextNames = driver.getContextHandles();
for (String contextName : contextNames) {
    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
}
driver.context(contextNames.toArray()[1]); // set context to WEBVIEW_1

//do some web testing
String myText = driver.findElement(By.cssSelector(".green_button")).click();

driver.context("NATIVE_APP");

// do more native testing if we want

driver.quit();

	 */

	public void switchContext(String context) {

		System.out.println("Before Switching : " + driver.getContext());

		Set<String> con = driver.getContextHandles();

		for (String c : con) {

			System.out.println("Available Context : " + c);

			if (c.contains(context)) {

				driver.context(c);
				
				
				//prints out something like NATIVE_APP \n WEBVIEW_1
				System.out.println("driver.context(c):- "+driver.context(c));
				

				break;
			}
		}

		System.out.println("After Switching : " + driver.getContext());
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

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

	/**
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { Tutorial16 obj = new Tutorial16();
	 * obj.setUp(); obj.getWebViewText(); obj.tearDown(); }
	 */

}
