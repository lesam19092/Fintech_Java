package org.example.converter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.pojo.City;
import org.example.pojo.Coordinates;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class XmlConverterTest {

    @Test
    public void checkThatFileIsNotNull() throws IOException {
        City city = new City("spb", new Coordinates());

        city.getCoords().setLat(59.939095);
        city.getCoords().setLon(30.315868);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("response.xml"), city);
        File file = new File("response.xml");


        assertNotNull(file);
    }

    @Test
    public void checkThatFileIsNotEmpty() throws IOException {
        City city = new City("spb", new Coordinates());

        city.getCoords().setLat(59.939095);
        city.getCoords().setLon(30.315868);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("response.xml"), city);
        File file = new File("response.xml");
        String dataFromFile = getDataFromXML(file);
        String data = "<City><slug>spb</slug><coords><lat>59.939095</lat><lon>30.315868</lon></coords></City>";

        assertEquals(dataFromFile, data);

    }

    private String getDataFromXML(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder data = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            data.append(line);

        }

        br.close();

        return data.toString();
    }

}