package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentData {
    public static void main(String[] args) {
        JSONArray subjects = new JSONArray();

        subjects.put("Hindi");
        subjects.put("English");
        subjects.put("Maths");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Kapil");
        jsonObject.put("age",20);
        jsonObject.put("subjects",subjects);
        System.out.println(jsonObject.toString()+"\n");
    }
}
