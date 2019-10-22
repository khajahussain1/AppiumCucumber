package com.Appium.stepdefination;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Appium.utility.ManagerReader;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	ManagerReader managerReader;

	public Hooks(ManagerReader reader) {
		
		managerReader = reader;
	}

	@Before
	public void BeforeSteps() {
		
		Reporter.assignAuthor("KHAJA HUSSAIN");
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) {

		if (scenario.isFailed()) {

			String screenshotName = scenario.getName().replaceAll(" ", "_");

			System.out.println(screenshotName);

			try {

				File sourcePath = ((TakesScreenshot) managerReader.getWebDriverManager().getDriver())
						.getScreenshotAs(OutputType.FILE);

				File destinationPath = new File(
						System.getProperty("user.dir") + "/target/screenshots/" + screenshotName + ".png");

				System.out.println(destinationPath);

				Files.copy(sourcePath, destinationPath);

				Reporter.addScreenCaptureFromPath(destinationPath.toString());

			} catch (IOException e) {
			}
		}
	}

	@After(order = 0)
	public void AfterSteps() {
		
		managerReader.getWebDriverManager().closeDriver();
	}

}
