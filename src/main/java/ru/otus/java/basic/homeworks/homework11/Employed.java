package ru.otus.java.basic.homeworks.homework11;

import java.util.ArrayList;

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

    public static ArrayList<String> empGetNames(ArrayList<Employed> employees) {
        ArrayList<String> names = new ArrayList<>();
        for (Employed employee : employees) {
            names.add(employee.getName());
        }
        System.out.println("Имена сотрудников " + names);
        return names;
    }

    public static ArrayList<String> empGetNamesMinAge(ArrayList<Employed> employees, int minAge) {
        ArrayList<String> employeesAge = new ArrayList<>();
        for (Employed employed : employees) {
            if (employed.getAge() >= minAge) {
                employeesAge.add(String.valueOf(employed.getName()));
            }
        }
        System.out.println("Сотрудники старше минимального возраста " + employeesAge);
        return employeesAge;
    }

    public static boolean empGetNamesAverAge(ArrayList<Employed> employees, int minAverAge) {
        int sumAge = 0;
        for (Employed employed : employees) {
            sumAge += employed.getAge();
        }
        int averAge = sumAge / 2;
        if (averAge > minAverAge) {
            System.out.println("Средний возраст сотрудников превышает минимальный " + minAverAge);
            return true;
        }
        System.out.println("Средний возраст сотрудников не превышает минимальный " + minAverAge);
        return false;
    }

    public static ArrayList<String> empGetUng(ArrayList<Employed> employees) {
        int minAge = employees.get(0).getAge();
        Employed result = new Employed();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i + 1).getAge() < minAge) {
                minAge = employees.get(i + 1).getAge();
                result = employees.get(i + 1).getName();
            }
        }
        System.out.println(result);
        return result;
    }

}
