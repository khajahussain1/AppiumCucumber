package com.Appium.utility;

import java.io.IOException;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	
	private FileReaderManager()
	{
		
	}
	
	public static FileReaderManager getInstance( )
	{
		return fileReaderManager;
	}
	
	public ConfigFileReader getConfigReader() throws IOException
	{
		if(configFileReader == null)
		{
			configFileReader = new ConfigFileReader();
			
		}
		return configFileReader;
	}

}
