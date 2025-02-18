package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/employee.csv";        // Original CSV file
        String outputFile = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/updated_employees.csv"; // Updated CSV file

        List<String[]> employeeData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Store header separately
                if (firstLine) {
                    firstLine = false;
                    employeeData.add(data);
                    continue;
                }

                // Check if the employee is from the IT department
                if (data[2].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3].trim());
                    salary *= 1.10; // Increase by 10%
                    data[3] = String.format("%.2f", salary); // Format to 2 decimal places
                }

                employeeData.add(data);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Write updated data to a new CSV file
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (String[] emp : employeeData) {
                writer.append(String.join(",", emp)).append("\n");
            }
            System.out.println("Updated employee records saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

