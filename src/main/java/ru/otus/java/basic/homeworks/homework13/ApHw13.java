package ru.otus.java.basic.homeworks.homework13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApHw13 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        new Person("Vasya", Position.DEVELOPER, 1l);
        System.out.println(String.valueOf(people));
    }
}

