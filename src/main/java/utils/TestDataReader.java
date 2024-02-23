package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDataReader {


    @SneakyThrows
    public static <T> T dataReader(String path, Class<T> typeValue){
        ObjectMapper mapper = new ObjectMapper();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/test_data/" + path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            return mapper.readValue(fileInputStream, typeValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



