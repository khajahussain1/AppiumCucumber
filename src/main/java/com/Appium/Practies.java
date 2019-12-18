package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practies {
	WebDriver driver;
	DesiredCapabilities cap = new DesiredCapabilities();

	@BeforeTest
	public void test() throws MalformedURLException {
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("deviceName", "realme 3 Pro");
		cap.setCapability("udid", "159b3828");
		cap.setCapability("platformName", "Android");
		cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(CapabilityType.VERSION, "9");
		

		/*cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "realme 3 Pro");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("androidPackage", "com.android.chrome");
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.get("http://www.yahoo.com");*/

	}
	
	@Test
	public void test1() throws MalformedURLException
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("usr.dir")+"/libs/chromedriver1.exe");
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.get("http://www.amazon.com");
	}

}
