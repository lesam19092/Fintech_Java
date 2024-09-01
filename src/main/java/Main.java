import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.converter.XmlConverter;
import org.example.pojo.City;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private static final Logger logger = Logger.getLogger(XmlConverter.class.getName());

    public static void main(String[] args) throws IOException {

        File file = new File("city.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            City city = objectMapper.readValue(file, City.class);
            System.out.println(city.toString());
            XmlConverter.toXml(city);
        } catch (JsonParseException exception) {
            logger.log(Level.SEVERE, exception.getMessage());
        }
    }
}
