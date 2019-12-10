package com.Appium.Managers;

import com.Appium.pageobjects.Add_two_numbers;
import com.Appium.pageobjects.Webapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectManager {

	private AppiumDriver<MobileElement> driver;
	private Add_two_numbers add_two_numbers;
	private Webapp webapp;

	public PageObjectManager(AppiumDriver<MobileElement> driver) {
		
		this.driver = driver;
	}

	public Add_two_numbers getadd_two_numbers() {
		
		
		if (add_two_numbers == null) {
			
			add_two_numbers = new Add_two_numbers(driver);
		}
		
		return add_two_numbers;

	}
	
	public Webapp getwebapp()
	{
		if(webapp == null)
		{
			webapp = new Webapp(driver);
		}
		
		return webapp;
	}

}
