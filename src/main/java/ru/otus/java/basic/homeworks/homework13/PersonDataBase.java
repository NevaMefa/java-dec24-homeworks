package ru.otus.java.basic.homeworks.homework13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDataBase {
    private Map<Long, String> personDataBase;

    public PersonDataBase(List<Person> persons) {
        this.personDataBase = new HashMap<>();
        for (Person person : persons){
            personDataBase.put(person.id, person.toString());
        }
    }
}
