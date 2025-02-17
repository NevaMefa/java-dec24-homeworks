package ru.otus.java.basic.homeworks.homework9.People;

import ru.otus.java.basic.homeworks.homework9.Terrain;
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

    public boolean board(Transport transport) {
        if (this.currentTransport == null) {
            this.currentTransport = transport;
            System.out.println(name + " сел на " + this.currentTransport);
            return true;
        } else {
            System.out.println("я уже сижу на " + this.currentTransport);
            return false;
        }
    }


    public boolean mount(Transport transport) {
        if (this.currentTransport != null) {
            if (this.currentTransport != transport) {
                System.out.println("я не сижу на " + transport);
                return false;
            } else {
                System.out.println("Я встал с " + this.currentTransport);
                this.currentTransport = null;
                return true;
            }
        } else {
            System.out.println("я и так стою " + this.currentTransport);
        }
        return false;
    }

    public boolean travel(int distance, Terrain terrain) {
        if (this.currentTransport == null) {
            System.out.println(name + " не может путешествовать без транспорта.");
            return false;
        } else {
            currentTransport.travel(distance, terrain);
            return true;
        }
    }
}
