package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read two JSON files
            JsonNode json1 = objectMapper.readTree(new File("D:/WEEK5/JSONData/src/main/java/org/example/file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("D:/WEEK5/JSONData/src/main/java/org/example/file2.json"));

            // Merge both JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            // Print merged JSON
            String mergedJsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson);
            System.out.println(mergedJsonString);

            // Optionally, write merged JSON to a new file
            objectMapper.writeValue(new File("merged.json"), mergedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
