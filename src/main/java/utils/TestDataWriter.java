package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import lombok.SneakyThrows;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

	public static void writeData(Object object, String path) throws FileNotFoundException {
		ObjectMapper objectMapper = new ObjectMapper();
		FileOutputStream fileOutputStream = new FileOutputStream("src\\test\\resources\\testdata" + path);

		try {
			objectMapper.writeValue(fileOutputStream, object);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void writeData2(String jsonData, String fileName) {
		try (FileWriter fileWriter = new FileWriter("src\\test\\resources\\testdata\\" + fileName)) {
			fileWriter.write(jsonData);
			System.out.println("Test data written to file successfully.");
		}
		catch (IOException e) {
			System.err.println("Error writing test data to file: " + e.getMessage());
		}
	}

}
