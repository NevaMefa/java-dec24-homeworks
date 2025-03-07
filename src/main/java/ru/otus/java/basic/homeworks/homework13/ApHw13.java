package ru.otus.java.basic.homeworks.homework13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.otus.java.basic.homeworks.homework13.Position.getManagerPos;

public class ApHw13 {
    public static void main(String[] args) {
        PersonDataBase people = new PersonDataBase();
        Person person1 = new Person(1l, "Vasya", Position.DEVELOPER);
        Person person2 = new Person(2l, "Viktoria", Position.MANAGER);
        Person person3 = new Person(3l, "Leonid", Position.PLUMBER);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.printPersonDataBase();
        System.out.println(people.findByld(2l));
        System.out.println(people.isManager(person2));
        System.out.println(people.isEmployee(3l));
        int[] array = {1,5,7,9,11};
        BubleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}

