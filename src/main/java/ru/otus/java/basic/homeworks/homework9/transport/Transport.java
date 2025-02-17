package ru.otus.java.basic.homeworks.homework9.transport;

import ru.otus.java.basic.homeworks.homework9.Terrain;

public class Transport {
    String transport;
    int fuel;
    int fuelRate;

    public Transport(String transport) {
        this.transport = transport;
        this.fuelRate = 1;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public String getName() {
        return this.transport;
    }

    public void info() {
        System.out.println(this.transport);
    }


    @Override
    public String toString() {
        return transport; // Теперь при выводе транспорта будет показываться его название
    }


    public boolean travel(int distance, Terrain terrain) {
        if (this.fuel <= fuelRate * distance) {
            System.out.println("Проехал " + distance + "км");
            return true;
        }
        return false;
    }
}
