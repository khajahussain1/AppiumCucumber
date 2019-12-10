package com.Appium.utility;

import java.io.IOException;

import com.Appium.Managers.PageObjectManager;
import com.Appium.Managers.AppiumDriverManager;

public class TestContext {

	private AppiumDriverManager appiumDriverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() throws IOException {
		
		appiumDriverManager = new AppiumDriverManager();
		pageObjectManager = new PageObjectManager(appiumDriverManager.getDriver());
	}

	public AppiumDriverManager getappiumDriverManager() {
		
		return appiumDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		
		return pageObjectManager;
	}
}
