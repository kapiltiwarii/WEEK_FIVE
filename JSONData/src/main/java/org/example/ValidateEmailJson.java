package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.regex.Pattern;

public class ValidateEmailJson {
    // Email validation regex
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static void main(String[] args) throws JsonProcessingException {

        String jsonData = "{ \"email\": \"test@example.com\" }";
       // String jsonData = "{ \"email\": \"invalid-email\" }";  //
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode  =  objectMapper.readTree(jsonData);
        try {

            // Check if "email" exists and validate
            if (rootNode.has("email")) {
                String email = rootNode.get("email").asText();
                if (EMAIL_PATTERN.matcher(email).matches()) {
                    System.out.println(" Valid email: " + email);
                } else {
                    System.out.println("Invalid email format: " + email);
                }
            } else {
                System.out.println(" JSON does not contain 'email' field!");
            }
        } catch (Exception e) {
            System.out.println(" Invalid JSON format!");
        }
    }
}
