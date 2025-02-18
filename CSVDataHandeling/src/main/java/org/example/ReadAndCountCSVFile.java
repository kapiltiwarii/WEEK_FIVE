package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountCSVFile {
    public static void main(String[] args) {
        String fileName = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/students.csv"; // CSV file name
        int count = 0;
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

                // Display structured output
                System.out.println("Student Record:");
                System.out.println("ID    : " + data[0]);
                System.out.println("Name  : " + data[1]);
                System.out.println("Age   : " + data[2]);
                System.out.println("Marks : " + data[3]);
                System.out.println();
                count++;
            }
        } catch (
                IOException e) {
            System.out.print("Error reading file: " + e.getMessage());
        }finally {
            System.out.println("The Number of Rows in the csv file is : "+count);
        }

    }
}
