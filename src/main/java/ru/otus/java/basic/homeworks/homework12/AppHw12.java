package ru.otus.java.basic.homeworks.homework12;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AppHw12 {
    public static void main(String[] args) {
        PhoneBookDirectory directory = new PhoneBookDirectory();
        directory.add(79114443322L, "Pupkin Vasiliy Nikolaevich");
        directory.add(79112223344L, "Pupkin Vasiliy Nikolaevich");
        directory.add(79111335577L, "Sidorov Nikolai Viktorovich");
        directory.add(79815558899L, "Petrov Ivan Nikolaevich");
        directory.printPhoneBook();
        System.out.println("Найденные Номера : " + directory.find(" Vasiliy Nikolaevich"));
        directory.containsPhoneNumber(79815558834L);
    }
}
