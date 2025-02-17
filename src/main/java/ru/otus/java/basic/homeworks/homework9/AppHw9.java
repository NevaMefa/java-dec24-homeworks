package ru.otus.java.basic.homeworks.homework9;

import ru.otus.java.basic.homeworks.homework9.People.Human;
import ru.otus.java.basic.homeworks.homework9.transport.*;

import java.awt.event.WindowFocusListener;

public class AppHw9 {
    public static void main(String[] args) {
        Car car = new Car(100);
        Bike bike = new Bike();
        Horse horse = new Horse(100);
        AllVehicle allVehicle = new AllVehicle(100);
        Human human = new Human("Boris", 100);
        human.board(allVehicle);
        human.travel(10,Terrain.swamp);

    }
}
