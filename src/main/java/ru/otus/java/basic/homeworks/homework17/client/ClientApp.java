package ru.otus.java.basic.homeworks.homework17.client;

import java.io.IOException;

public class ClientApp {
    public static void main(String[] args) {
        try {
            new Client();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
