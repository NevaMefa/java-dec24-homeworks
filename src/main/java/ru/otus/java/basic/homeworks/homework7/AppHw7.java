package ru.otus.java.basic.homeworks.homework7;

import ru.otus.java.basic.homeworks.homework7.animals.Cat;
import ru.otus.java.basic.homeworks.homework7.animals.Dog;
import ru.otus.java.basic.homeworks.homework7.animals.Horse;

public class AppHw7 {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 5, 5, 100);
        Dog dog = new Dog("Belka", 8, 8, 100);
        Horse horse = new Horse("Wild", 10, 10, 100);
        cat.swim(10);
        cat.info();
        dog.swim(30);
        dog.info();
        horse.info();
        System.out.println(horse.swim(5));


    }
}
