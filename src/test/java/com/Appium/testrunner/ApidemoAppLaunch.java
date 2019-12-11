package com.Appium.testrunner;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Appium.Managers.FileReaderManager;
import com.Appium.utility.Log;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/feature/ApidemoAppLaunch.feature" }, glue = {
		"classpath:com/Appium/stepdefination" }, plugin = { "pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent-reports/Extentreport.html",
				"html:target/cucumber-html-reports", "json:target/cucumber-json-reports/cucumber.json",
				"junit:target/cucumber-junit-reports/cucumber.xml" }, strict = true, dryRun = false, monochrome = true, snippets = SnippetType.CAMELCASE)

public class ApidemoAppLaunch extends AbstractTestNGCucumberTests {

	String testcasename;

	@BeforeClass
	public void beforeclass() {

		testcasename = this.getClass().getSimpleName();

		System.out.println("***************** " + testcasename + " Test satrting *****************");

		DOMConfigurator.configure("log4j.xml");

		Log.startTestCase(testcasename);
	}

	@AfterClass
	public void setup() throws IOException {

		/*File fi = new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath());
		Reporter.loadXMLConfig(fi);*/

		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_171");

		Log.endTestCase(testcasename);
		System.out.println("***************** " + testcasename + " Test end *****************");
	}

}
