package org.example;

import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String fileName = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/employee.csv";  // The CSV file name
        List<String[]> employeeData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;
            String[] header = null;

            // Read the CSV file
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Store the header separately
                if (firstLine) {
                    header = data;
                    firstLine = false;
                    continue;
                }

                // Add employee data to the list
                employeeData.add(data);
            }

            // Bubble Sort employees by Salary (Descending order)
            for (int i = 0; i < employeeData.size(); i++) {
                for (int j = 0; j < employeeData.size() - 1 - i; j++) {
                    try {
                        double salaryA = Double.parseDouble(employeeData.get(j)[3].trim());
                        double salaryB = Double.parseDouble(employeeData.get(j + 1)[3].trim());

                        // Swap if salaryB is higher than salaryA
                        if (salaryA < salaryB) {
                            String[] temp = employeeData.get(j);
                            employeeData.set(j, employeeData.get(j + 1));
                            employeeData.set(j + 1, temp);
                        }
                    } catch (NumberFormatException e) {
                        // Ignore any errors when parsing salary
                    }
                }
            }

            // Print the top 5 highest-paid employees
            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println("--------------------------------------");
            System.out.println(String.join(" | ", header));  // Print header

            // Print the top 5 employees
            for (int i = 0; i < Math.min(5, employeeData.size()); i++) {
                System.out.println(String.join(" | ", employeeData.get(i)));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

