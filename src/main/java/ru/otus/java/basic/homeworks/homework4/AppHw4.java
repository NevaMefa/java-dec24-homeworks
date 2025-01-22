package ru.otus.java.basic.homeworks.homework4;

import java.util.Arrays;

public class AppHw4 {
    public static void main(String[] args) {
        first(4, "Привет!");
        sumNumbers(2, 5, 6, 7, 1, 1);
        int[] arr = new int[3];
        numbNew(4, arr);
        int[] arr1 = {1, 2, 3, 4, 5};
        newNumbMassiv(5, arr1);
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
        System.out.println("Сумма: " + sum);
    }

    public static void numbNew(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = number;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void newNumbMassiv(int numb, int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] += numb;
        }
        System.out.println(Arrays.toString(arr1));
    }
}
