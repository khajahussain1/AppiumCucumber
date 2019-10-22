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
/**
 * @author CHIRAG
 *
 */
public class Tutorial17 {

	AndroidDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "HTC Desire 626 dual sim");
		cap.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/app/ApiDemos.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyOTPValue() throws InterruptedException
	{
		driver.findElementByAccessibilityId("OS").click();
		driver.findElementByAccessibilityId("SMS Messaging").click();
		driver.findElementById("io.appium.android.apis:id/sms_recipient").sendKeys("9290543618");
		
		driver.findElementById("io.appium.android.apis:id/sms_content").sendKeys("DEMO OTP: 6549");
		driver.findElementByAccessibilityId("Send").click();
	String otpValue = getOTP();
		System.out.println("OTP VALUE : "+otpValue);

	    	}
	
	
	public String getOTP() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		//driver.startActivity("com.android.mms", "com.android.mms.ui.ConversationList");
//		cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
//		cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
//		
		driver.findElementByXPath("//*[text='+919290543618  20']").click();
		System.out.println("welcome to hyd");
		String getOTPValue = driver.findElementById("com.android.messaging:id/conversation_snippet").getText().split(":")[1].trim();
		return getOTPValue;
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
		Tutorial17 obj = new Tutorial17();
		obj.setup();
		obj.verifyOTPValue();
		obj.tearDown();

	}
*/
}
