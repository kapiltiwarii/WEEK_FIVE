package org.example;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String fileName = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/employees.csv";  // The CSV file name
        List<String[]> validRecords = new ArrayList<>();
        List<String[]> invalidRecords = new ArrayList<>();

        // Regex for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;
            String[] header = null;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Store the header separately
                if (firstLine) {
                    header = data;
                    firstLine = false;
                    continue;
                }

                // Validate Email (index 2) and Phone Number (index 3)
                boolean isValidEmail = isValidEmail(data[2], emailPattern);
                boolean isValidPhone = isValidPhoneNumber(data[3]);

                if (isValidEmail && isValidPhone) {
                    validRecords.add(data);  // Add to valid list if both are valid
                } else {
                    invalidRecords.add(data);  // Add to invalid list if any is invalid
                    if (!isValidEmail) {
                        System.out.println("Invalid email: " + data[2] + " in row: " + Arrays.toString(data));
                    }
                    if (!isValidPhone) {
                        System.out.println("Invalid phone number: " + data[3] + " in row: " + Arrays.toString(data));
                    }
                }
            }

            // Output valid records
            System.out.println("Valid Records:");
            for (String[] record : validRecords) {
                System.out.println(String.join(" | ", record));
            }

            // Output invalid records
            System.out.println("\nInvalid Records:");
            for (String[] record : invalidRecords) {
                System.out.println(String.join(" | ", record));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to validate email
    public static boolean isValidEmail(String email, Pattern pattern) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method to validate phone number (must be exactly 10 digits)
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");  // Checks if phone number contains exactly 10 digits
    }
}
