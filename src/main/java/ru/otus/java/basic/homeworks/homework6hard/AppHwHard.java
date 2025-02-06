package ru.otus.java.basic.homeworks.homework6hard;

import java.util.Scanner;

public class AppHwHard {
    public static void main(String[] args) {
        Box box1 = new Box(1, "Black", true);
        box1.info();
        box1.deleteItem();
        box1.close();
        box1.deleteItem();
        box1.open();
        box1.setItem();
    }
}
