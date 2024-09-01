package org.example.converter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.pojo.City;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
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