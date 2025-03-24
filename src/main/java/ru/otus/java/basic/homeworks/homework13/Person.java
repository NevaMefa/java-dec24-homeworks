package ru.otus.java.basic.homeworks.homework13;

import javax.swing.text.Position;

public class Person  {
    String name;
    Position position;
    Long id;

    public Person(Long id, String name, Position position) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    public Person(long id) {

    }

    @Override
    public String toString() {
        return "Person{" + "id" + id + " , Name " + name + " " + position + "}";
    }

}
