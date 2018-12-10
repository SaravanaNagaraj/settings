package com.pointel.settings;

import com.pointel.settings.bean.Database;
import com.pointel.settings.bean.Logger;

public interface SettingsServiceInterface {

	public Database getDatabaseProperties();
	
	public boolean setDatabaseProperties(Database database);
	
	public Logger getLoggerProperties();
	
}
