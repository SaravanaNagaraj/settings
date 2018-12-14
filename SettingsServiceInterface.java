package com.pointel.settings;

import com.pointel.settings.bean.Database;
import com.pointel.settings.bean.General;
import com.pointel.settings.bean.Logger;
import com.pointel.settings.bean.Login;

public interface SettingsServiceInterface {

	public Database getDatabaseProperties();

	public boolean setDatabaseProperties(Database database);

	public Logger getLoggerProperties();

	public boolean setLoggerProperties(Logger logger);

	public General getGeneralProperties();

	public boolean setGeneralProperties(General app);

	public Login getLoginProperties();

	public boolean setLoginProperties(Login login);
	
	public boolean isValidSettingsCredential(String userName, String password);

}
