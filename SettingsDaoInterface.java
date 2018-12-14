package com.pointel.settings;

import java.util.Properties;

public interface SettingsDaoInterface {

	public Properties getDatabaseProperties();

	public boolean setDatabaseProperties(Properties properties);

	public Properties getLoggerProperties();

	public boolean setLoggerProperties(Properties properties);

	public Properties getGeneralProperties();

	public boolean setGeneralProperties(Properties properties);

	public Properties getLoginProperties();

	public boolean setLoginProperties(Properties properties);

}
