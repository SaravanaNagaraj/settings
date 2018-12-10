package com.pointel.settings;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
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

	@Override
	public Properties getDatabaseProperties() {

		Properties properties = new Properties();

		try {
			properties.load(servletContext.getResourceAsStream(FOLDER_PATH + DATABASE_FILE));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	@Override
	public boolean setDatabaseProperties(Properties properties) {

		try {
			properties.load(servletContext.getResourceAsStream(FOLDER_PATH + DATABASE_FILE));
			
			properties.setProperty("newKey", "VAL");
			
			properties.store(new FileOutputStream(FOLDER_PATH + DATABASE_FILE), null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
