package ru.otus.java.basic.homeworks.homework17.server;

public class ServerApp {
    public static void main(String[] args) {
        try {
            new Server(8189).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

