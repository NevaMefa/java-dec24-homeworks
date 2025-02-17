package ru.otus.java.basic.homeworks.homework9.People;

import ru.otus.java.basic.homeworks.homework9.transport.Transport;

public class Human {
    private String name;
    private Transport currentTransport = null;
    private int maxStamina;

    public Human(String name, int maxStamina) {
        this.name = name;
        this.maxStamina = maxStamina;
    }

    public void info() {
        System.out.println(name + " оставшиеся силы " + maxStamina);
    }

    public Transport getCurrentTransport() {
        return this.currentTransport;
    }

    public void setCurrentTransport(Transport currentTransport) {
        this.currentTransport = currentTransport;
    }

    public void board(Transport transport) {
        if (getCurrentTransport() != null) {
            System.out.println(name + " уже сидит на " + transport.getName());
        } else {
            setCurrentTransport(transport);
            System.out.println(name + " сел на " + transport.getName());
        }
    }


    public void standUp(Transport transport) {

    }


}
