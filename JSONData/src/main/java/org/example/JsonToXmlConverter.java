package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            // Sample JSON String
            String jsonData = "{ \"name\": \"John\", \"age\": 30, \"city\": \"New York\" }";

            // Convert JSON to JsonNode
            JsonNode jsonNode = jsonMapper.readTree(jsonData);

            // Convert JsonNode to XML String
            String xmlData = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

            // Print XML Output
            System.out.println(xmlData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
