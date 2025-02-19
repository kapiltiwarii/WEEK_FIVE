package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Car {
    public String brand;
    public String model;
    public int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car("Mahindra","Thar",2018);

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writeValueAsString(car);

        System.out.println(jsonString);
    }
}
