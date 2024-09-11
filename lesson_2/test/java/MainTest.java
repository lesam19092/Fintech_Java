import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.pojo.City;
import org.example.pojo.Coordinates;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MainTest {
    @Test
    public void checkValueFromValidJson() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String cityJson = "{\n" +
                "  \"slug\": \"spb\",\n" +
                "  \"coords\": {\n" +
                "    \"lat\": 59.939095,\n" +
                "    \"lon\": 30.315868\n" +
                "  }\n" +
                "}\n";

        City city = new City("spb", new Coordinates());

        city.getCoords().setLat(59.939095);
        city.getCoords().setLon(30.315868);

        City cityToTest = objectMapper.readValue(cityJson, City.class);

        assertEquals(city, cityToTest);

    }

    @Test
    public void checkValueFromUnValidJson() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String cityJson = "{\n" +
                "  \"slug\": \"spb\",\n" +
                "  \"coo: {\n" +
                "    \"lat\": 59.939095,\n" +
                "    \"lon\": 30.315868\n" +
                "  }\n" +
                "}\n";

        try {
            City cityToTest = objectMapper.readValue(cityJson, City.class);
        } catch (JsonParseException exception) {
            assertEquals(JsonParseException.class, exception.getClass());
        }

    }

}