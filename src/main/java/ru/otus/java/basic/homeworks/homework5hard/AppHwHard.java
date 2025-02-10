package ru.otus.java.basic.homeworks.homework5hard;

import java.util.Arrays;

public class AppHwHard {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] array = {1, 2, 3};
        sumMet();
        findEqual(array);
        compareInc(arr);
        mirrorMass();
    }

    // заданиние со звездой
    public static void sumMet() {
        int[] met1 = {1, 2, 3};
        int[] met2 = {3, 4, 5};
        int[] met3 = {6, 7, 8};
        int[] metSum = new int[met1.length + met2.length + met3.length];
        for (int i = 0; i < met1.length; i++) {
            metSum[i] = met1[i] + met2[i] + met3[i];
        }
        System.out.println(Arrays.toString(metSum));
    }

    public static void findEqual(int... array) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < array.length; i++) {
            sum1 += array[i];
        }
        for (int i = 0; i < array.length - 1; i++) {
            sum2 += array[i];
            sum1 -= array[i];
            if (sum2 == sum1) {
                System.out.println("Равенство достигнуто между позициями " + i + " и " + (i + 1));
                break;
            } else {
                if (i == array.length - 2) {
                    System.out.println("Равенство не найдено");
                }
            }
        }
    }

    // проверка возрастания или убывания массива
    public static void compareInc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                System.out.println("Массив возврастающий");
                return;
            } else {
                if (arr[i] > arr[i + 1]) {
                    System.out.println("Массив убывающий");
                    return;
                }
            }
        }
    }

    // отзеркаливание массива
    public static void mirrorMass() {
        int[] arr = {1, 2, 3, 4, 5};
        int table = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            table = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = table;
        }
        System.out.println(Arrays.toString(arr));
    }
}
