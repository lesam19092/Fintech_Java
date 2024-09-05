package org.example.converter;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.City;

import java.io.File;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class XmlConverter {

    public static void toXml(City city) {
        log.debug("method toXml started");
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File("response.xml"), city);
            log.info("XML file written into responce.xml with body " + city.toString());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.debug("method toXml ended");
    }

}