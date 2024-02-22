package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestDataWriter {

	private static Logger LOGGER = LogManager.getLogger(TestDataWriter.class);

	public void writeResponseBodyToJsonFile(String responseBody, String fileName) {

		String filePath = "src/test/resources/testdata/" + fileName + ".json";
		File file = new File(filePath);

		if (!file.exists()) {
			try (FileWriter fileWriter = new FileWriter(filePath)) {
				fileWriter.write(responseBody);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			LOGGER.debug("Test data saved under {}", fileName);
		}
		else
			LOGGER.debug("File already exists. Test data wasn't saved.");

	}

}
