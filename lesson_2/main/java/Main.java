import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.converter.XmlConverter;
import org.example.pojo.City;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("city.json");
        ObjectMapper objectMapper = new ObjectMapper();
        if (!file.exists()) {
            log.warn("File " + file.getName() + " not found. Processing might fail.");
            return;
        }
        try {
            City city = objectMapper.readValue(file, City.class);
            log.debug("city is created successfully");
            XmlConverter.toXml(city);
        } catch (JsonParseException exception) {
            log.error(exception.getMessage());
        }
    }
}
