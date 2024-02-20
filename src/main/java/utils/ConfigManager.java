package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigManager {

	private static final Logger LOGGER = LogManager.getLogger(ConfigManager.class);

	private static final Properties properties = new Properties();

	static {
		try (InputStream inputStream = ConfigManager.class.getClassLoader()
			.getResourceAsStream("application.properties")) {
			properties.load(inputStream);
			LOGGER.info("Application properties loaded successfully.");
		}
		catch (Exception e) {
			LOGGER.error("Could not load application properties.", e);
		}
	}

	private static void saveProperties() {
		try (OutputStream outputStream = new FileOutputStream("src/test/resources/application.properties")) {
			properties.store(outputStream, "Access Token");
		}
		catch (IOException e) {
			System.err.println("Could not save properties: " + e.getMessage());
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static void setProperty(String key, String value) {
		properties.setProperty(key, value);
		saveProperties();
		LOGGER.info("{} set successfully", key);
	}

}
