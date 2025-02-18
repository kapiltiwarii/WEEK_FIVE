package org.example;

import java.io.*;
import java.util.*;

public class ReadCSV {
    public static void main(String[] args) {
        String fileName = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/students.csv"; // CSV file name

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
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
