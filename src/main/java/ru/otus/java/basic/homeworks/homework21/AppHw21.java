package ru.otus.java.basic.homeworks.homework21;

import java.util.Arrays;

public class AppHw21 {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 1, 2, 2};
        int[] input2 = {2, 2, 2, 2};
        int[] a1 = {1, 2};
        int[] a2 = {1, 1};
        int[] a3 = {1, 3};
        int[] a4 = {2, 2};
        int[] a5 = {1, 2, 2};

        int[] result1 = Massiv.getElementAfterOne(input1);
        System.out.println(Arrays.toString(result1));
        int[] result2 = Massiv.getElementAfterOne(input2);
        System.out.println(Arrays.toString(result2));

        System.out.println(Massiv.checkArray(a1));
        System.out.println(Massiv.checkArray(a2));
        System.out.println(Massiv.checkArray(a3));
        System.out.println(Massiv.checkArray(a4));
        System.out.println(Massiv.checkArray(a5));
    }
}
