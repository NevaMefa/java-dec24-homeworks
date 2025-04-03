package ru.otus.java.basic.homeworks.homework17.server;

public interface AuthenticatedProvider {
    void initialize();
    boolean authenticate(ClientHand clientHandler, String login, String password);
    boolean registration(ClientHand clientHandler, String login, String password, String username);
}