package com.pointel.settings;

import java.util.Properties;

public interface SettingsDaoInterface {

	public Properties getDatabaseProperties();
	
	public boolean setDatabaseProperties(Properties properties);
	
	

/*	public Map<String, String> getApplicationProperties();

	public Map<String, String> getLoggerProperties();

	public Map<String, String> getLoginProperties();*/

}
