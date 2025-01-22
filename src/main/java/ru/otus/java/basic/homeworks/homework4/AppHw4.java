package ru.otus.java.basic.homeworks.homework4;

import java.util.Arrays;

public class AppHw4 {
    public static void main(String[] args) {
        //first(4, "Привет!");
        //sumNumbers(2, 5, 6, 7, 1, 1);
        numbNew(3);
    }

    public static void first(int count, String text) {
        for (int i = 0; i < count; i++)
            System.out.println(i + ". " + text);
    }

    public static void sumNumbers(int... array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5) {
                sum += array[i];
            }
        }
        System.out.println("Сумма:" + sum);
    }

    public static void numbNew(int number) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = number;
        }
        System.out.println(Arrays.toString(arr));
    }

}
