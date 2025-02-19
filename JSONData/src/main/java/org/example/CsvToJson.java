package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

public class CsvToJson {
    public static void main(String[] args) {
        String csvFile = "D:/WEEK5/JSONData/src/main/java/org/example/data.csv"; // Ensure this file exists
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> csvData = reader.readAll();
            if (csvData.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            // Extract headers (first row)
            String[] headers = csvData.get(0);

            // Create JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            // Convert rows to JSON
            for (int i = 1; i < csvData.size(); i++) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                String[] row = csvData.get(i);
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], row[j]);
                }
                jsonArray.add(jsonObject);
            }

            // Convert JSON array to pretty string
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
            System.out.println(jsonOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
