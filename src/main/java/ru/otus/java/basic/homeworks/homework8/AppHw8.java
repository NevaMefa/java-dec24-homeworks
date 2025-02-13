package ru.otus.java.basic.homeworks.homework8;

import java.sql.Array;
import java.util.Arrays;

public class AppHw8 {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
      //  Cat cat = new Cat("Masik", 100);
//cat.eat(plate);
        Cat[] cats = {new Cat("Boris", 10),
                new Cat("Murzik", 30),
                new Cat("Belok", 40),
                new Cat("lu4ik", 30)};
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }
    }


}
