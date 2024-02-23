package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestDataReader {

    public static String readData2(String fileName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/test/resources/testData/" + fileName)));
            return content;
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
            return null;
        }
    }




    public static <T> T readData(String path, Class<T> valueType) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    FileInputStream fileInputStream;

        try {
        fileInputStream = new FileInputStream("src\\test\\resources\\testdata\\" + path);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }


        return mapper.readValue(fileInputStream, valueType);
    }




}
