package com.Appium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Appium.testbase.Testbase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Add_two_numbers {

	AppiumDriver<MobileElement> driver;
	
	Testbase testbase;

	public Add_two_numbers(AppiumDriver<MobileElement> driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		testbase = new Testbase();
	}

	//@AndroidFindBy(id= "com.android.calculator2:id/digit7")
	@FindBy(xpath = "//*[@text='7']")
	@AndroidFindBy(xpath = "//*[@text='7']")
	public WebElement numberseven_button;
	

	@FindBy(id = "plus")
	@AndroidFindBy(accessibility = "plus")
	public WebElement plusbutton;

	@FindBy(xpath = "//*[@text='2']")
	@AndroidFindBy(xpath = "//*[@text='2']")
	public WebElement numbertwo_button;

//	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.calculator2:id/equal']")
//	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.calculator2:id/equal']")
	@FindBy(xpath = "//*[@text='=']")
	@AndroidFindBy(xpath = "//*[@text='=']")
	public WebElement equal_button;

	public void setnumberseven() {
		numberseven_button.click();
	}

	public void plus_button() {
		plusbutton.click();
	}

	public void setnumber() {
		numbertwo_button.click();
	}

	public void equal_button() {
		equal_button.click();
	}
}
