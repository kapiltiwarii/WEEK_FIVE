package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IPLCensorAnalyzer {

    public static void main(String[] args) {
        // File Paths
        String jsonInputFile = "D:/WEEK5/JSONData/src/main/java/org/example/ipl_matches.json";
        String csvInputFile = "D:/WEEK5/JSONData/src/main/java/org/example/ipl_matches.csv";
        String jsonOutputFile = "D:/WEEK5/JSONData/src/main/java/org/example/censored_ipl.json";
        String csvOutputFile = "D:/WEEK5/JSONData/src/main/java/org/example/censored_ipl.csv";

        // Process JSON and CSV
        processJSON(jsonInputFile, jsonOutputFile);
        processCSV(csvInputFile, csvOutputFile);
    }


    public static void processJSON(String inputFile, String outputFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode matches = (ArrayNode) objectMapper.readTree(new File(inputFile));

            for (JsonNode match : matches) {
                ObjectNode obj = (ObjectNode) match;
                obj.put("team1", censorTeam(obj.get("team1").asText()));
                obj.put("team2", censorTeam(obj.get("team2").asText()));
                obj.put("winner", censorTeam(obj.get("winner").asText()));
                obj.put("player_of_match", "REDACTED");
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), matches);
            System.out.println("JSON Data Censored & Saved to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Process CSV File
    public static void processCSV(String inputFile, String outputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> rows = reader.readAll();
            List<String[]> censoredRows = new ArrayList<>();

            // Modify Header Row
            censoredRows.add(rows.get(0));

            // Censor Team Names & Player of the Match
            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                row[1] = censorTeam(row[1]); // team1
                row[2] = censorTeam(row[2]); // team2
                row[5] = censorTeam(row[5]); // winner
                row[6] = "REDACTED"; // player_of_match
                censoredRows.add(row);
            }

            // Write to Output CSV
            writer.writeAll(censoredRows);
            System.out.println("CSV Data Censored & Saved to " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Censor Team Name (Replace last word with "***")
    private static String censorTeam(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***";
        }
        return String.join(" ", words);
    }
}

