package org.example;

import java.io.*;
import java.util.Scanner;

public class SearchCSV {
    public static void main(String[] args) {
        String fileName = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/employee.csv"; // CSV file name
        Scanner scanner = new Scanner(System.in);

        // Get employee name input
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                // Skip header line
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                String name = data[1].trim(); // Get employee name

                // Check if name matches
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("\nEmployee Found:");
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary    : $" + data[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}
