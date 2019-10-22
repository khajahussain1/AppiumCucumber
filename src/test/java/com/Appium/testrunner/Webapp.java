package com.Appium.testrunner;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "./feature/Webapp.feature" }, glue = {
		"classpath:com/Appium/stepdefination" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:src/main/java/extent_reports/Extentreport.html",
				"html:target/cucumber-reports" }, tags = { "@Sanity", "~@Regresion" })

public class Webapp extends AbstractTestNGCucumberTests {

	@AfterClass
	public static void setup() throws IOException {
		File fi = new File("target/extent-config.xml");
		Reporter.loadXMLConfig(fi);
		// Reporter.setSystemInfo("user", System.getProperty("user.name"));
		// Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		// Reporter.setSystemInfo("os", "Mac OSX");
		// Reporter.setTestRunnerOutput("Sample test runner output message");
	}

}
