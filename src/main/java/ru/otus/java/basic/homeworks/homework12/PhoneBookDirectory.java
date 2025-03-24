package ru.otus.java.basic.homeworks.homework12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBookDirectory {
    private HashMap<Long, String> phoneBookMap;

    public PhoneBookDirectory() {
        this.phoneBookMap = new HashMap<>();
    }


    public void add(long numberPhone, String fullName) {
        phoneBookMap.put(numberPhone, fullName);
        System.out.println("Добавили в книгу " + numberPhone + " " + fullName);
    }

    public Map<Long, String> find(String fullName) {
        Map<Long, String> result = new HashMap<>();
        for (Map.Entry<Long, String> entry : phoneBookMap.entrySet()) {
            if (entry.getValue().equals(fullName)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        if (result.isEmpty()) {
            return null;
        } else {
            return result;
        }
    }

    public void printPhoneBook() {
        for (var entry : phoneBookMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void containsPhoneNumber(long phoneNumber) {
        System.out.println(phoneBookMap.getOrDefault(phoneNumber, "Номера нет в справочнике"));
    }


}
