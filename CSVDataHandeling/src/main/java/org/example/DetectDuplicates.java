package org.example;

import java.io.*;
import java.util.*;

public class DetectDuplicates {

    public static void main(String[] args) {
        String fileName = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/sampleData.csv";  // Path to your CSV file
        Set<String> seenIds = new HashSet<>();  // To track seen IDs
        List<String[]> duplicateRecords = new ArrayList<>();  // List to store duplicate records
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Skip the header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Split the line by commas
                String[] data = line.split(",");

                // Extract the ID from the first column
                String id = data[0];

                // Check if the ID has been seen before
                if (seenIds.contains(id)) {
                    duplicateRecords.add(data);  // Add the duplicate record to the list
                } else {
                    seenIds.add(id);  // Mark the ID as seen
                }

                recordCount++;
            }

            // Print the duplicate records
            if (!duplicateRecords.isEmpty()) {
                System.out.println("Duplicate records found:");
                for (String[] record : duplicateRecords) {
                    System.out.println(String.join(", ", record));
                }
            } else {
                System.out.println("No duplicates found.");
            }

            System.out.println("Total records processed: " + recordCount);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
