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

    public int decreaseFuel(int amount) {
        this.fuel -= amount;
        if (this.fuel < 0) {
            this.fuel = 0; // Не допускаем отрицательного значения топлива
        }
        return this.fuel;
    }

    public boolean travel(int distance, Terrain terrain) {
        int fuelneed = this.fuelRate * distance;
        if (getFuel() <= fuelneed) {
            System.out.println("Проехал " + distance + "км");
            return true;
        }
        return false;
    }
}
