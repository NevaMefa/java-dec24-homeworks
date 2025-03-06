package ru.otus.java.basic.homeworks.homework13;

public class BubleSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean needSort;
        for (int i = 0; i < n - 1; i++) {
            needSort = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен элементов
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    needSort = true;
                }
            }
            if (!needSort) {
                break;
            }
        }
    }
}

