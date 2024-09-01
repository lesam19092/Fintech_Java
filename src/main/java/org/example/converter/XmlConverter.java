package org.example.converter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.pojo.City;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlConverter {
    private XmlConverter() {
    }

    private static final Logger logger = Logger.getLogger(XmlConverter.class.getName());

    public static void toXml(City city) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File("response.xml"), city);
            logger.log(Level.INFO, "XML file written ");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

}