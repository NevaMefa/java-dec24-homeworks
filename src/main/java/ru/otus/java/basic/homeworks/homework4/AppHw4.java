package ru.otus.java.basic.homeworks.homework4;

public class AppHw4 {
    public static void main(String[] args) {
        first(4, "Привет!");
    }

    public static void first(int count, String text) {
        for (int i = 0; i < count; i++)
            System.out.println(i + ". " + text);
    }


}
