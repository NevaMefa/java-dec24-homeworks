package ru.otus.java.basic.homeworks.homework4;

import java.util.Arrays;

public class AppHw4 {
    public static void main(String[] args) {
        first(4, "Привет!");
        sumNumbers(2, 5, 6, 7, 1, 1);
        int[] arr = new int[3];
        numbNew(4, arr);
        int[] arr1 = {8, 7, 7, 4, 5, 6};
        newNumbMassiv(5, arr1);
        compNumb(arr1);
        sumMet();
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

    public static void compNumb(int[] arr1) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < arr1.length / 2; i++) {
            sumLeft += arr1[i];
        }
        for (int i = arr1.length / 2; i < arr1.length; i++) {
            sumRight += arr1[i];
        }
        if (sumLeft > sumRight) {
            System.out.println("Сумма левой половины больше: " + sumLeft);
        } else {
            System.out.println("Сумма правой половины больше: " + sumRight);
        }
    }

    // заданиние со звездой
    public static void sumMet() {
        int[] met1 = {1, 2, 3};
        int[] met2 = {3, 4, 5};
        int[] met3 = {6, 7, 8};
        int[] metSum = new int[met1.length + met2.length + met3.length];
        for (int i = 0; i < met1.length; i++){
            metSum[i] = met1[i] + met2[i] + met3[i];
        }
        System.out.println(Arrays.toString(metSum));
    }
}
