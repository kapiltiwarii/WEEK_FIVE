package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/students1.csv";  // students1.csv contains ID, Name, Age
        String file2 = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/students2.csv";  // students2.csv contains ID, Marks, Grade
        String outputFile = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/merged_students.csv";  // Output file for merged data

        // Maps to store data
        Map<String, String[]> students1Data = new HashMap<>();
        Map<String, String[]> students2Data = new HashMap<>();

        // Read the first CSV file (students1.csv)
        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean firstLine = true;

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");

                // Skip header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Store student data from students1.csv in a map with ID as the key
                String id = data[0];
                String name = data[1];
                String age = data[2];
                students1Data.put(id, new String[]{name, age});
            }

        } catch (IOException e) {
            System.out.println("Error reading file " + file1 + ": " + e.getMessage());
        }

        // Read the second CSV file (students2.csv)
        try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean firstLine = true;

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");

                // Skip header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Store student data from students2.csv in a map with ID as the key
                String id = data[0];
                String marks = data[1];
                String grade = data[2];
                students2Data.put(id, new String[]{marks, grade});
            }

        } catch (IOException e) {
            System.out.println("Error reading file " + file2 + ": " + e.getMessage());
        }

        // Merge the data from both CSVs based on the ID and write to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Write the header to the output file
            writer.write("ID,Name,Age,Marks,Grade\n");

            // Merge the records based on ID
            for (String id : students1Data.keySet()) {
                if (students2Data.containsKey(id)) {
                    String[] student1 = students1Data.get(id);
                    String[] student2 = students2Data.get(id);

                    // Merge the data from both files and write to the output file
                    String mergedRecord = String.join(",", id, student1[0], student1[1], student2[0], student2[1]);
                    writer.write(mergedRecord + "\n");
                }
            }

            System.out.println("Merged data has been written to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error writing to file " + outputFile + ": " + e.getMessage());
        }
    }
}
