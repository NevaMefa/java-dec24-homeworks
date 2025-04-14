package ru.otus.java.basic.homeworks.homework17.postgres;

import java.util.List;

public interface UserExample {
    List<User> getAll();

    boolean isAdmin(int userId);
}
