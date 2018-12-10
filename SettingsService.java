package com.pointel.settings;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointel.settings.bean.Database;
import com.pointel.settings.bean.Logger;

import com.pointel.settings.bean.info.DatabaseInfo;

@Service
public class SettingsService implements SettingsServiceInterface {

	@Autowired
	private SettingsDao settingsDao;

	@Override
	public Database getDatabaseProperties() {

		Database database = new Database();

		Properties properties = settingsDao.getDatabaseProperties();

		for (String name : properties.stringPropertyNames()) {
			
			if (DatabaseInfo.DATABASE_IP.equals(name)) {
				database.setIp(properties.getProperty(name));
			} 
			else if (DatabaseInfo.DATABASE_PORT.equals(name)) {
				database.setPort(properties.getProperty(name));
			} 
			else if (DatabaseInfo.DATABASE_DBNAME.equals(name)) {
				database.setDbname(properties.getProperty(name));
			}
			else if (DatabaseInfo.DATABASE_USERNAME.equals(name)) {
				database.setUsername(properties.getProperty(name));
			}
			else if(DatabaseInfo.DATABASE_PASSWORD.equals(name)) {
				database.setPassword(properties.getProperty(name));
			}
		}

		return database;
	}

	@Override
	public boolean setDatabaseProperties(Database database) {
		
		Properties properties = new Properties();
		properties.setProperty(DatabaseInfo.DATABASE_IP, database.getIp());
		properties.setProperty(DatabaseInfo.DATABASE_PORT, database.getPort());
		properties.setProperty(DatabaseInfo.DATABASE_DBNAME, database.getDbname());
		properties.setProperty(DatabaseInfo.DATABASE_PASSWORD, database.getPassword());
		properties.setProperty(DatabaseInfo.DATABASE_USERNAME, database.getUsername());
		
		return settingsDao.setDatabaseProperties(properties);
		
	}

	@Override
	public Logger getLoggerProperties() {
		
		
		
		return null;
	}



}
