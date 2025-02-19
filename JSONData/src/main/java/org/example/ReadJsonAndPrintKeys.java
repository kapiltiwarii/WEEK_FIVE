package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonAndPrintKeys {
    public static void main(String[] args) throws Exception {
        // Load JSON file
        File jsonFile = new File("D:/WEEK5/JSONData/src/main/java/org/example/data.json"); // JSON file path
        ObjectMapper objectMapper = new ObjectMapper();

        // Parse JSON into JsonNode
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        // Recursively print all keys and values
        printJsonKeysAndValues(rootNode, "");
    }

    public static void printJsonKeysAndValues(JsonNode node, String parentKey) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJsonKeysAndValues(entry.getValue(), parentKey + entry.getKey() + ".");
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJsonKeysAndValues(node.get(i), parentKey + i + ".");
            }
        } else {
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " : " + node.asText());
        }
    }
}
