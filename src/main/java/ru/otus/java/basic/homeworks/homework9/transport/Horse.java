package ru.otus.java.basic.homeworks.homework9.transport;

import ru.otus.java.basic.homeworks.homework9.Terrain;

public class Horse extends Transport {
    private int stamina;

    public Horse(int stamina) {
        super("horse");
        this.stamina = stamina;
    }

    public Horse(String name) {
        super(name);
    }

    @Override
    public void info() {
        System.out.println(transport + stamina);
    }

//    @Override
//    public void road(int distance, Terrain terrain) {
//        if (terrain == Terrain.swamp){
//            System.out.println("Я не смогу тут проехать");
//        } else {
//            this.fuel = fuel - distance;
//            System.out.println("Проехали " + terrain + " сил осталось " + fuel);
//        }
//    }
}
