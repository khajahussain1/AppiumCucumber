package com.Appium.stepdefination;

import java.util.Map;

import com.Appium.pageobjects.Add_two_numbers;
import com.Appium.pageobjects.Webapp;
import com.Appium.utility.ConfigFileReader;
import com.Appium.utility.ManagerReader;
import com.Appium.utility.PageObjectManager;
import com.Appium.utility.WebDriverManager;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Stepdefination {

	AppiumDriver<MobileElement> driver;

	Add_two_numbers twonumbers;
	
	Webapp webapp;

	PageObjectManager pageObjectManager;
	
	ConfigFileReader configFileReader;
	
	WebDriverManager webDriverManager;
	
	ManagerReader managerReader;
	
	public Stepdefination(ManagerReader reader)
	{
		managerReader = reader;
		twonumbers = managerReader.getPageObjectManager().getadd_two_numbers();
		webapp = managerReader.getPageObjectManager().getwebapp();
	}

	@Given("^Launch the application in mobile \"([^\"]*)\"$")
	public void launch_the_application_in_mobile(String apptype) throws Throwable {
//		webDriverManager = new WebDriverManager();
//		driver = webDriverManager.getDriver();
//		//Testbase.launchapp(apptype);
//		pageObjectManager = new PageObjectManager(driver);

	}

	@Then("^Click on number seven$")
	public void click_on_number_seven() {

		//twonumbers = pageObjectManager.getadd_two_numbers();
		twonumbers.setnumberseven();
	}

	@Then("^click on plus button$")
	public void click_on_plus_button() {
		twonumbers.plus_button();
	}

	@Then("^click on number two$")
	public void click_on_number_two() {
		twonumbers.setnumber();
	}

	@Then("^Click on equal button$")
	public void click_on_equal_button() {
		twonumbers.equal_button();
	}

	@Then("^Pass the value as \"([^\"]*)\"$")
	public void pass_the_value_as(String appium) throws InterruptedException {
	}
	
	@Given("^user enters credentials to the login$")
	public void user_enters_credentials_to_the_login(DataTable usercredentials) throws Throwable {
		for(Map<String, String> data : usercredentials.asMaps(String.class, String.class)) {
		
		System.out.println(data.get("Username"));
		System.out.println(data.get("Password"));
		}
	    
	}

}
