package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataWriter {

    @SneakyThrows
    public static void dataWriter(Object object, String path) {
        ObjectMapper mapper = new ObjectMapper();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "/src/test" +
                    "/resources/test_data/" + path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            mapper.writeValue(fileOutputStream, object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}