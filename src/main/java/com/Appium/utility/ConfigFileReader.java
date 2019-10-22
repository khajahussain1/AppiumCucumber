package com.Appium.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.Appium.enums.AppType;
import com.Appium.enums.EnvironmentType;

public class ConfigFileReader {

	private Properties pro;
	private final String propertyFilePath = "src/test/resources/configs/Configuation.properties";

	public ConfigFileReader() {
		try {

			FileInputStream reader = new FileInputStream(propertyFilePath);
			pro = new Properties();
			try {
				pro.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getAppPath() {

		String AppPath = pro.getProperty("APPPATH");

		System.out.println(AppPath);

		if (AppPath != null) {

			return AppPath;

		} else {

			throw new RuntimeException("AppPath not specified in the Configuration.properties file.");

		}
	}

	public String geturl() {

		String url = pro.getProperty("URL");

		if (url != null) {

			return url;

		} else {
			throw new RuntimeException("url not specified in the Configuration.properties file.");
		}
	}

	public AppType getapp() {
		
		String appname = pro.getProperty("APP");

		if (appname == null || appname.equals("native")) {
			
			return AppType.NATIVE;

		} else if (appname.equalsIgnoreCase("hybrid")) {
			
			return AppType.HYBRIDE;
			
		} else if (appname.equalsIgnoreCase("webapp")) {
			
			return AppType.WEBAPP;

		} else {
			throw new RuntimeException("app Name Key value in Configuration.properties is not matched : " + appname);
		}
	}

	//
	public EnvironmentType getEnvironment() {
		String environmentName = pro.getProperty("ENVIRONMENT");

		if (environmentName == null || environmentName.equals("local")) {
			return EnvironmentType.LOCAL;

		} else if (environmentName.equalsIgnoreCase("remote")) {
			return EnvironmentType.REMOTE;
		} else {
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
		}

	}

	public String getReportConfigPath() {

		String reportConfigPath = pro.getProperty("REPORTCONFIGPATH");

		if (reportConfigPath != null) {

			return reportConfigPath;

		} else {

			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
		}
	}

	public String getploatform() {

		String ploatform = pro.getProperty("PLOTFORM");

		if (ploatform != null) {

			return ploatform;

		} else {

			throw new RuntimeException(
					"ploatform not specified in the Configuration.properties file for the Key:reportConfigPath");
		}
	}

	public String getappPackage() {
		
		String appPackage = pro.getProperty("APPPACKAGE");

		if (appPackage != null) {
			return appPackage;

		} else {

			throw new RuntimeException(
					"appPackage not specified in the Configuration.properties file for the Key:reportConfigPath");
		}
	}

	public String getappActivity() {
		
		String appActivity = pro.getProperty("APPACTIVITY");

		if (appActivity != null) {
			return appActivity;

		} else {

			throw new RuntimeException(
					"appActivity not specified in the Configuration.properties file for the Key:reportConfigPath");
		}
	}
	
	public String getDevicename()
	{
		String devicename = pro.getProperty("DEVICENAME");
		
		if(devicename!=null)
		{
			return devicename;
			
		}
		else {

			throw new RuntimeException(
					"devicename not specified in the Configuration.properties file for the Key:reportConfigPath");
		}
	}
	
	public long getimplicitywait()
	{
		String implicity = pro.getProperty("IMPLICITYWAIT");
		
		if(implicity!=null)
		{
			return Long.parseLong(implicity);
			
		}
		else {

			throw new RuntimeException(
					"devicename not specified in the Configuration.properties file for the Key:reportConfigPath");
		}
	}
}
