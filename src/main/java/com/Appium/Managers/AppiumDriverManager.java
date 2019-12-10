package com.Appium.Managers;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.Appium.enums.AppType;
import com.Appium.enums.EnvironmentType;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumDriverManager {

	private AppiumDriver<MobileElement> driver;
	private static AppType appType;
	private static EnvironmentType environmentType;

	public AppiumDriverManager() throws IOException {

		appType = FileReaderManager.getInstance().getConfigReader().getapp();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();

	}
	public AppiumDriver<MobileElement> getDriver() throws IOException {

		if (driver == null) {
			driver = createDriver();

		}
		return driver;
	}

	private AppiumDriver<MobileElement> createDriver() throws IOException {

		if (environmentType.name().equals("LOCAL")) {

			driver = createLocalDriver();

		} else if (environmentType.name().equals("REMOTE")) {

			driver = createRemoteDriver();

		}

		return driver;
	}

	private AppiumDriver<MobileElement> createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private AppiumDriver<MobileElement> createLocalDriver() throws IOException {

		if (FileReaderManager.getInstance().getConfigReader().getploatform().equals("ANDROID")) {
			
			if (appType.name().equals("NATIVE")) {

				DesiredCapabilities cap = new DesiredCapabilities();
				
				cap.setCapability("platformName", "Android");
				
				cap.setCapability("deviceName", FileReaderManager.getInstance().getConfigReader().getDevicename());
				
				cap.setCapability("appPackage", FileReaderManager.getInstance().getConfigReader().getappPackage());
				
				cap.setCapability("appActivity", FileReaderManager.getInstance().getConfigReader().getappActivity());
				
				URL url = new URL(FileReaderManager.getInstance().getConfigReader().geturl());
				
				driver = new AndroidDriver<MobileElement>(url, cap);
				

			} else if (appType.name().equals("HYBRIDE")) {
				
				System.out.println("Session is creating");
				
				DesiredCapabilities cap = new DesiredCapabilities();
				
				cap.setCapability("platformName", "Android");
				
				cap.setCapability("deviceName", FileReaderManager.getInstance().getConfigReader().getDevicename());
				
				cap.setCapability("app", System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getAppPath());
				
				URL url = new URL(FileReaderManager.getInstance().getConfigReader().geturl());

				driver = new AndroidDriver<MobileElement>(url, cap);

				System.out.println("Session is created");

			} else if (appType.name().equals("WEBAPP")) {
				
				DesiredCapabilities cap = new DesiredCapabilities();
				
				cap.setCapability("platformName", "Android");
				
				cap.setCapability("deviceName", FileReaderManager.getInstance().getConfigReader().getDevicename());
				
				cap.setCapability("browserName", "Chrome");
				
				URL url = new URL(FileReaderManager.getInstance().getConfigReader().geturl());
				
				driver = new AndroidDriver<MobileElement>(url, cap);
				
				driver.get("http://www.google.com");
			}
			
			driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getimplicitywait(), TimeUnit.SECONDS);

		}

		else if (FileReaderManager.getInstance().getConfigReader().getploatform().equals("IOS")) {
			
			if (appType.name().equals("NATIVE")) {

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("platformName", "ios");
				cap.setCapability("deviceName", "HTC Desire 626 dual sim");
				cap.setCapability("appPackage", "com.android.calculator2");
				cap.setCapability("appActivity", "com.android.calculator2.Calculator");
				// cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
				// cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
				URL url = new URL("http://0.0.0.0:4723/wd/hub");
				driver = new AndroidDriver<MobileElement>(url, cap);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			} else if (appType.name().equals("HYBRIDE")) {
				
				System.out.println("Session is creating");
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("platformName", "ios");
				cap.setCapability("deviceName", "Nexus 9");
				cap.setCapability("app", System.getProperty("user.dir") + "/app/ApiDemos.apk");
				URL url = new URL("http://0.0.0.0:4723/wd/hub");

				driver = new AndroidDriver<MobileElement>(url, cap);

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("Session is created");

			} else if (appType.name().equals("chrome")) {
				
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("platformName", "ios");
				cap.setCapability("deviceName", "HTC Desire 626 dual sim");
				cap.setCapability("browserName", "Chrome");
				URL url = new URL("http://0.0.0.0:4723/wd/hub");
				driver = new AndroidDriver<MobileElement>(url, cap);
				driver.get("http://www.google.com");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}

		}
		return driver;
	}

	public void closeDriver() {
		
		driver.quit();
	}
}
