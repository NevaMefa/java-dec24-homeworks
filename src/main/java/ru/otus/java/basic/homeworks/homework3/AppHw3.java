package ru.otus.java.basic.homeworks.homework3;

import java.util.Scanner;

public class AppHw3 {
    public static void main(String[] args) {
//        greetings();
//        checkSign(1, 2, -33);
//        selectColor();
//        compareNumbers();
//        addOrSubtractAndPrint(1, 2, true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число от 1 до 5");
        int met = scanner.nextInt();
        if (met == 1) {
            greetings();
        } else if (met == 2) {
            checkSign(1, 2, -33);
        } else if (met == 3) {
            selectColor();
        } else if (met == 4) {
            compareNumbers();
        } else if (met == 5) {
            addOrSubtractAndPrint(1, 2, true);
        } else
            System.out.println("Такого метода не существует");

    }

    public static void greetings() {
        System.out.println("Hello \nWorld\nfrom \nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");

        }
    }

    public static void selectColor() {
        int data = 15;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 3;
        int b = 2;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }

}