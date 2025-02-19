package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) throws Exception {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Define two JSON strings
        String json1 = "{ \"name\": \"John Doe\", \"email\": \"johndoe@example.com\" }";
        String json2 = "{ \"age\": 30, \"city\": \"New York\" }";

        // Convert JSON strings to ObjectNode
        ObjectNode node1 = (ObjectNode) objectMapper.readTree(json1);
        ObjectNode node2 = (ObjectNode) objectMapper.readTree(json2);

        // Merge: Copy all key-value pairs from node2 to node1
        node1.setAll(node2);

        // Print merged JSON
        String mergedJson = objectMapper.writeValueAsString(node1);
        System.out.println("Merged JSON:\n" + mergedJson);
    }
}
