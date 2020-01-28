package com.ariat.Utils;

import java.io.IOException;
import java.util.Properties;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;

public class CredentialsUtils {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(CredentialsUtils.class);
	private static final Properties properties = loadProperties();

	private static Properties loadProperties() {
		try {
			Properties prop = new Properties();
			prop.load(CredentialsUtils.class.getClassLoader().getResourceAsStream("credentials.properties.txt"));
			return prop;
		} catch (IOException e) {
			logger.error("Error ocured while loading properties {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public static String getProperty(String property) {
		return properties.getProperty(property);
	}
}
