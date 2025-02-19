package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static void main(String[] args) {
        String validJson = "{ \"name\": \"John Doe\", \"age\": 30 }";
        String invalidJson = "{ \"name\": \"John Doe\", \"age\": 30, }"; // Invalid JSON

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("Valid JSON: " + isValidJson(validJson, objectMapper));
        System.out.println("Invalid JSON: " + isValidJson(invalidJson, objectMapper));
    }

    public static boolean isValidJson(String json, ObjectMapper objectMapper) {
        try {
            objectMapper.readTree(json); // Try parsing JSON
            return true; // JSON is valid
        } catch (Exception e) {
            return false; // JSON is invalid
        }
    }
}

