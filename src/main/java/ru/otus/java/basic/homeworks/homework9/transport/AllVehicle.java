package ru.otus.java.basic.homeworks.homework9.transport;

import ru.otus.java.basic.homeworks.homework9.Terrain;

public class AllVehicle extends Transport {

    public AllVehicle(int fuel) {
        super("allVehicle");
        this.fuel = fuel;
        this.fuelRate = 2;
    }

    public AllVehicle(String name) {
        super(name);
    }


    @Override
    public void info() {
        System.out.println(transport + this.fuel);
    }

    @Override
    public boolean travel(int distance, Terrain terrain) {
            setFuel(this.fuel -= distance * this.fuelRate);
            System.out.println("Проехал " + terrain + " бензина осталось " + getFuel());
            return true;
    }
}
