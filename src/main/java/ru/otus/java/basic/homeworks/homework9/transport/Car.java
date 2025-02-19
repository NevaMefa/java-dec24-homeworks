package ru.otus.java.basic.homeworks.homework9.transport;

import ru.otus.java.basic.homeworks.homework9.Terrain;

public class Car extends Transport {


    public Car(int fuel) {
        super("car");
        this.fuel = fuel;
        this.fuelRate = 1;
    }



    public Car(String name) {
        super(name);
    }

    @Override
    public void info() {
        System.out.println(transport + fuel);
    }

    @Override
    public boolean travel(int distance, Terrain terrain) {
        if (terrain == Terrain.Swamp || terrain == Terrain.Forest) {
            System.out.println("Я не смогу тут проехать");
            return false;
        } else {
            setFuel(getFuel() - (distance * this.fuelRate));
            System.out.println("Проехал " + terrain + " бензина осталось " + getFuel());
            return true;
        }
    }
}