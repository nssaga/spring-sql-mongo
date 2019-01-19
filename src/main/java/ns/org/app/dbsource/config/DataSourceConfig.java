/**
  DBSourceConfiguration.java
 ***********************************************************************************************************************
 Description: 	

 Revision History:
 -----------------------------------------------------------------------------------------------------------------------
 Date         	Author               	Reason for Change
 -----------------------------------------------------------------------------------------------------------------------
 16-Dec-2018		Nawal Sah				Initial Version

 Copyright (c) 2018,
 ***********************************************************************************************************************
 */
package ns.org.app.dbsource.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import ns.org.app.dbsource.constant.AppConstants;
import ns.org.app.dbsource.constant.DbTypes;

public class DataSourceConfig {

	public Map<String, Object> excludeDBAutoconfiguration() {

		DbTypes dbType = DbTypes.getEnum(getDbType());

		Map<String, Object> map = new HashMap<>();

		// if database type is not Supported
		if (dbType == DbTypes.NOT_SUPPORTED) {
			System.out.println("Unable to detect database type - " + AppConstants.DB_TYPE_PROP);
		}

		// Exclude SQL Auto configuration
		if (dbType != DbTypes.SQL) {
			System.out.println("Excluding SQL auto configuration");
			map.put("spring.autoconfigure.exclude[0]",
					"org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration");
			map.put("spring.autoconfigure.exclude[1]",
					"org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration");
		}
		// Exclude NoSQL Auto configuration
		if (dbType != DbTypes.NO_SQL) {
			System.out.println("Excluding No SQL auto configuration");
			map.put("spring.autoconfigure.exclude[0]",
					"org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration");
			map.put("spring.autoconfigure.exclude[1]",
					"org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration");
			map.put("spring.autoconfigure.exclude[2]",
					"org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration");
		}

		return map;
	}

	private String getDbType() {
		String dbName = null;
		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "application.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return null;
			}
			prop.load(input);
			dbName = prop.getProperty(AppConstants.DB_TYPE_PROP);
			System.out.println(dbName);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dbName;

	}
}
