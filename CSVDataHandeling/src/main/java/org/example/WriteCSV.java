package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String fileName = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/employee.csv"; // Output CSV file

        // Sample employee data
        String[] employees = {
                "101,John Doe,IT,75000",
                "102,Jane Smith,HR,68000",
                "103,Michael Brown,Finance,72000",
                "104,Emily Davis,Marketing,70000",
                "105,David Wilson,Sales,73000"
        };

        try (FileWriter writer = new FileWriter(fileName)) {
            // Writing header
            writer.append("ID,Name,Department,Salary\n");

            // Writing employee records
            for (String emp : employees) {
                writer.append(emp).append("\n");
            }

            System.out.println("Employee records successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
