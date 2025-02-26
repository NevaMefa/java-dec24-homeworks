package ru.otus.java.basic.homeworks.homework11;

import java.util.ArrayList;
import java.util.Arrays;

public class Employed {
    private String name;
    private int age;

    public Employed(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<String> EmpGetNames(ArrayList<Employed> employees) {
        ArrayList<String> names = new ArrayList<>();
        for (Employed employee : employees) {
            names.add(employee.getName());
        }
        System.out.println("Именя сотрудников " + names);
        return names;
    }

//    public static ArrayList<String> EmpGetNamesMinAge(ArrayList<Employed> employees, int minAge) {
//
//    }
}
