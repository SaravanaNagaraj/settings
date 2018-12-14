package com.pointel.settings;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointel.settings.bean.Database;
import com.pointel.settings.bean.General;
import com.pointel.settings.bean.Logger;
import com.pointel.settings.bean.Login;
import com.pointel.settings.bean.info.DatabaseInfo;
import com.pointel.settings.bean.info.AppInfo;
import com.pointel.settings.bean.info.LoggerInfo;
import com.pointel.settings.bean.info.LoginInfo;

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
				
			} else if (DatabaseInfo.DATABASE_PORT.equals(name)) {
				database.setPort(properties.getProperty(name));
				
			} else if (DatabaseInfo.DATABASE_DB_NAME.equals(name)) {
				database.setDbName(properties.getProperty(name));
				
			} else if (DatabaseInfo.DATABASE_USER_NAME.equals(name)) {
				database.setUserName(properties.getProperty(name));
				
			} else if (DatabaseInfo.DATABASE_PASSWORD.equals(name)) {
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
		properties.setProperty(DatabaseInfo.DATABASE_DB_NAME, database.getDbName());
		properties.setProperty(DatabaseInfo.DATABASE_PASSWORD, database.getPassword());
		properties.setProperty(DatabaseInfo.DATABASE_USER_NAME, database.getUserName());

		return settingsDao.setDatabaseProperties(properties);
	}

	@Override
	public Logger getLoggerProperties() {

		Logger logger = new Logger();

		Properties properties = settingsDao.getLoggerProperties();

		for (String name : properties.stringPropertyNames()) {

			if (LoggerInfo.LOGGER_FILE_NAME.equals(name)) {
				logger.setFileName(properties.getProperty(name));
			
			} else if (LoggerInfo.LOGGER_PATH.equals(name)) {
				logger.setFilePath(properties.getProperty(name));
				
			} else if (LoggerInfo.lOGGER_FILE_SIZE.equals(name)) {
				logger.setFileSize(properties.getProperty(name));
				
			} else if (LoggerInfo.LOGGER_FILE_COUNT.equals(name)) {
				logger.setFileCount(properties.getProperty(name));
			}
		}

		return logger;
	}

	@Override
	public boolean setLoggerProperties(Logger logger) {
		
		Properties properties = new Properties();
		
		properties.setProperty(LoggerInfo.LOGGER_FILE_NAME, logger.getFileName());
		properties.setProperty(LoggerInfo.LOGGER_PATH, logger.getFilePath());
		properties.setProperty(LoggerInfo.lOGGER_FILE_SIZE, logger.getFileSize());
		properties.setProperty(LoggerInfo.LOGGER_FILE_COUNT, logger.getFileCount());

		return settingsDao.setLoggerProperties(properties);
	}

	@Override
	public General getGeneralProperties() {
		
		General general = new General();

		Properties properties = settingsDao.getGeneralProperties();

		for (String name : properties.stringPropertyNames()) {

			if (AppInfo.APP_DATE_FORMAT.equals(name)) {
				general.setDateFormat(properties.getProperty(name));
				
			} else if (AppInfo.APP_TIME_FORMAT.equals(name)) {
				general.setTimeFormat(properties.getProperty(name));
				
			} else if (AppInfo.APP_DATE_TIME_FORMAT.equals(name)) {
				general.setDateTimeFormat(properties.getProperty(name));
			}
		}

		return general;
	}

	@Override
	public boolean setGeneralProperties(General general) {
		
		Properties properties = new Properties();
		properties.setProperty(AppInfo.APP_DATE_FORMAT, general.getDateFormat());
		properties.setProperty(AppInfo.APP_TIME_FORMAT, general.getTimeFormat());
		properties.setProperty(AppInfo.APP_DATE_TIME_FORMAT, general.getDateTimeFormat());

		return settingsDao.setGeneralProperties(properties);
	}

	@Override
	public Login getLoginProperties() {
		
		Login login = new Login();

		Properties properties = settingsDao.getLoginProperties();

		for (String name : properties.stringPropertyNames()) {

			if (LoginInfo.SETTINGS_USERNAME.equals(name)) {
				login.setUserName(properties.getProperty(name));
				
			} else if (LoginInfo.SETTINGS_PASSWORD.equals(name)) {
				login.setPassword(properties.getProperty(name));
				
			}
		}

		return login;
	}

	@Override
	public boolean setLoginProperties(Login login) {
		
		Properties properties = new Properties();
		properties.setProperty(LoginInfo.SETTINGS_USERNAME, getLoginProperties().getUserName());
		properties.setProperty(LoginInfo.SETTINGS_PASSWORD, login.getPassword());

		return settingsDao.setLoginProperties(properties);
	}

	@Override
	public boolean isValidSettingsCredential(String userName, String password) {

		Login login = getLoginProperties();

		if (login.getUserName().trim().equalsIgnoreCase(userName) && login.getPassword().trim().equals(password)) {
			return true;

		}
		return false;
	}
}