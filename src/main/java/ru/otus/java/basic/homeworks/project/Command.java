package ru.otus.java.basic.homeworks.project;

public interface Command {
    String getName();
    void execute(String[] args);
}
