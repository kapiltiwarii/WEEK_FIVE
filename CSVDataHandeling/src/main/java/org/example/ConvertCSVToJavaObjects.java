package org.example;

import java.io.*;
import java.util.*;

class Student {
    private String id;
    private String name;
    private int age;
    private double marks;

    // Constructor
    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    // toString method to display student data
    @Override
    public String toString() {
        return "Student ID: " + id + " | Name: " + name + " | Age: " + age + " | Marks: " + marks;
    }
}

public class ConvertCSVToJavaObjects {

    public static void main(String[] args) {
        String fileName = "D:\\WEEK5\\CSVDataHandeling\\src\\main\\java\\org\\example/students.csv";  // The CSV file name
        List<Student> students = new ArrayList<>();  // List to store Student objects

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Skip the header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Convert CSV data to Student object and add to list
                String id = data[0];
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                double marks = Double.parseDouble(data[3]);

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

            // Print all Student objects
            System.out.println("List of Students:");
            for (Student student : students) {
                System.out.println(student);  // This will call the toString() method
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

