package com.Appium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Webapp {
	
	public AppiumDriver<MobileElement> driver;
	
	//WebDriver driver;
	
	public Webapp(AppiumDriver<MobileElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="q")
	@AndroidFindBy(xpath="//input[@id='q']")
	public WebElement txetbox;
	
	public void text_box(String appium)
	{
		txetbox.sendKeys(appium);
		driver.findElementByXPath("//input[@id='q']").sendKeys("appium");
	}

}
