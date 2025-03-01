package ru.otus.java.basic.homeworks.homework9.transport;

import ru.otus.java.basic.homeworks.homework9.Terrain;

public class Horse extends Transport {

    public Horse(int stamina) {
        super("horse");
        this.fuel = stamina;
    }

    public Horse(String name) {
        super(name);
    }

    @Override
    public void info() {
        System.out.println(transport + fuel);
    }

    @Override
    public boolean travel(int distance, Terrain terrain) {
        int fuelneed = this.fuel - distance;
        if (terrain == Terrain.SWAMP) {
            System.out.println("Я не смогу тут проехать");
            return false;
        } else {
            this.fuel = fuelneed;
            System.out.println("Проехали " + terrain + " сил осталось " + fuel);
            return true;
        }
    }
}
