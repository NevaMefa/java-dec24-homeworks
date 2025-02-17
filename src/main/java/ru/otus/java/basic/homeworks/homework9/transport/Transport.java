package ru.otus.java.basic.homeworks.homework9.transport;

import ru.otus.java.basic.homeworks.homework9.Terrain;

public class Transport {
    String transport;

    public Transport(String transport) {
        this.transport = transport;
    }

    public String getName() {
        return this.transport;
    }

    public void info() {
        System.out.println(this.transport);
    }
//    public void road(int distance, Terrain terrain){
//        this.fuel = fuel - distance;
//        System.out.println("Проехали " + terrain + " бензина осталось " + fuel);
//    }
}
