package ru.otus.java.basic.homeworks.homework8;

public class AppHw8 {
    public static void main(String[] args) {
        Plate plate = new Plate(20);
        Cat cat = new Cat("Murzik", 10);
        plate.infoPlate();
        cat.eat(plate);
        cat.eat(plate);
        cat.eat(plate);
    }
}
