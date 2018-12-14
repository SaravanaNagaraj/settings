package com.pointel.settings;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SettingsDao implements SettingsDaoInterface {

	@Autowired
	private ServletContext servletContext;

	private static final String FOLDER_PATH = "WEB-INF/properties/";

	private static final String DATABASE_FILE = "database.properties";
	private static final String LOGGER_FILE = "logger.properties";
	private static final String APP_FILE = "application.properties";
	private static final String LOGIN_FILE = "login.properties";

	@Override
	public Properties getDatabaseProperties() {

		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(servletContext.getRealPath(FOLDER_PATH + DATABASE_FILE)));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	@Override
	public boolean setDatabaseProperties(Properties properties) {

		FileOutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(servletContext.getRealPath(FOLDER_PATH + DATABASE_FILE));
			properties.store(outputStream, "Last Update - " + new Date());

			return true;

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		return false;
	}

	@Override
	public Properties getLoggerProperties() {

		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(servletContext.getRealPath(FOLDER_PATH + LOGGER_FILE)));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	@Override
	public boolean setLoggerProperties(Properties properties) {

		FileOutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(servletContext.getRealPath(FOLDER_PATH + LOGGER_FILE));
			properties.store(outputStream, "Last update - " + new Date());

			return true;

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		return false;
	}

	@Override
	public Properties getGeneralProperties() {

		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(servletContext.getRealPath(FOLDER_PATH + APP_FILE)));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	@Override
	public boolean setGeneralProperties(Properties properties) {

		FileOutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(servletContext.getRealPath(FOLDER_PATH + APP_FILE));
			properties.store(outputStream, "Last update - " + new Date());

			return true;

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		return false;
	}

	@Override
	public Properties getLoginProperties() {

		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(servletContext.getRealPath(FOLDER_PATH + LOGIN_FILE)));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	@Override
	public boolean setLoginProperties(Properties properties) {

		FileOutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(servletContext.getRealPath(FOLDER_PATH + LOGIN_FILE));
			properties.store(outputStream, "Last update - " + new Date());

			return true;

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		return false;
	}
}