package org.example;

import java.io.*;
import java.util.*;

public class ProcessLargeCSV {

    public static void main(String[] args) {
        String fileName = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/large_file.csv";  // Path to your large CSV file
        int chunkSize = 100;  // Process 100 lines at a time
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<String[]> chunkData = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                // Skip the header line
                if (recordCount == 0 && line.contains("ID")) {
                    continue;
                }

                // Process each line (you can store them in a chunk, if necessary)
                String[] data = line.split(",");
                chunkData.add(data);

                // Increment the record count
                recordCount++;

                // If we have processed a chunk of 100 lines, process the chunk
                if (chunkData.size() == chunkSize) {
                    processChunk(chunkData);
                    chunkData.clear();  // Clear the chunk data for the next batch
                }
            }

            // Process any remaining lines that didn't fill up the last chunk
            if (!chunkData.isEmpty()) {
                processChunk(chunkData);
            }

            // Print the total number of records processed
            System.out.println("Total records processed: " + recordCount);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Process each chunk of data
    private static void processChunk(List<String[]> chunkData) {
        // Process the chunk here (e.g., store, analyze, etc.)
        // For this example, we're just printing the size of the chunk
        System.out.println("Processed " + chunkData.size() + " records.");
    }
}
