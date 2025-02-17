package ru.otus.java.basic.homeworks.homework9.transport;

import ru.otus.java.basic.homeworks.homework9.Terrain;

public class Car extends Transport {
    private int fuel;

    public Car(int fuel) {
        super("car");
        this.fuel = fuel;
    }

    public Car(String name) {
        super(name);
    }

    @Override
    public void info() {
        System.out.println(transport + fuel);
    }
//    @Override
//    public void road(int distance, Terrain terrain) {
//        if (terrain == Terrain.swamp || terrain == Terrain.forest) {
//            System.out.println("Я не смогу тут проехать");
//        } else {
//            this.fuel = fuel - distance;
//            System.out.println("Проехали " + terrain + " бензина осталось " + fuel);
//        }
//    }
}