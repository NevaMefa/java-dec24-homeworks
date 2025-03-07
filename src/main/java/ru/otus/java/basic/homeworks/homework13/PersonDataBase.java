package ru.otus.java.basic.homeworks.homework13;

import java.util.*;

import static ru.otus.java.basic.homeworks.homework13.Position.*;

public class PersonDataBase {
    private static Map<Long, Person> personDataBase = new HashMap<>();

    public PersonDataBase() {
        this.personDataBase = new HashMap<>();
    }


    public void printPersonDataBase() {
        for (var entry : personDataBase.entrySet()) {
            System.out.println(" " + entry.getKey() + "-" + entry.getValue());
        }
    }

    public Person findByld(long id) {
        return personDataBase.get(id);
    }


    public void add(Person person) {
        personDataBase.put(person.id, person);
        System.out.println("add to personDataBase " + person.id + " " + person.name + " " + person.position);
    }

    public boolean isManager(Person person) {
        if (Position.getManagerPos().contains(person.position)) {
            return true;
        }
        return false;
    }

    public boolean isEmployee(Long id) {
        Person person = personDataBase.get(id);
        if (person == null) {
            return false;
        }
        if (getEmployeePos().contains(person.position)) {
            return true;
        }
        return false;
    }

   
}
