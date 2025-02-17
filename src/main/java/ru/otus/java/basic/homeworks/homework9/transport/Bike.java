package ru.otus.java.basic.homeworks.homework9.transport;

import ru.otus.java.basic.homeworks.homework9.Terrain;

public class Bike extends Transport {
    public Bike() {
        super("bike");
    }

    public Bike(String name) {
        super(name);
    }

//    @Override
//    public void road(int distance, Terrain terrain) {
//        if (terrain == Terrain.swamp) {
//            System.out.println("Я не смогу тут проехать");
//        } else {
//            this.fuel = fuel - distance;
//            System.out.println("Проехали " + terrain);
//        }
//    }
}
