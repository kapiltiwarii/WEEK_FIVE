package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJsonEmployee {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(new File("D:/WEEK5/JSONData/src/main/java/org/example/Employee.json"));

            String name =   rootNode.get("name").asText();
            String email =   rootNode.get("email").asText();

            System.out.println("Name :"+name);
            System.out.println("Email :"+email);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
