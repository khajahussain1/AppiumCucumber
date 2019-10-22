package com.Appium.testbase;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Testbase {

	public static AppiumDriver<MobileElement> driver;

	public static void verticalSwipe() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width / 2;
		int starty = (int) (height * 0.80);
		int endy = (int) (height * 0.20);
		//driver.swipe(x, starty, x, endy, 500);

	}

}
