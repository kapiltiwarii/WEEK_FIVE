package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

class Persons{
    public String name;
    public int age;
    public String city;

    public Persons(String name,int age,String city){
        this.name = name;
        this.age =age;
        this.city = city;
    }
}
public class ListToJson {
    public static void main(String[] args) throws JsonProcessingException {
        List<Persons> persons = new ArrayList<>();
        persons.add(new Persons("Kapil", 21, "Bhopal"));
        persons.add(new Persons("Kalpesh", 20, "Chhindwada"));
        persons.add(new Persons("Mohan", 26, "Patna"));

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(persons);
        System.out.println(jsonString);
    }
}
