package com.Appium.utility;

import java.io.IOException;

public class ManagerReader {

	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;

	public ManagerReader() throws IOException {
		
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}

	public WebDriverManager getWebDriverManager() {
		
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		
		return pageObjectManager;
	}
}
