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
            addOrSubtractAndPrint();
        } else
            System.out.println("Такого метода не существует");

    }

    // 1. Вывод приветствия
    public static void greetings() {
        System.out.println("Hello \nWorld\nfrom \nJava");
    }

    //2. Метод проверки суммы чисел
    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");

        }
    }

    //3. Метод выбора цвета
    public static void selectColor() {
        int data = (int) (Math.random() * 30);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //4. Метод сравнения чисел
    public static void compareNumbers() {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    //5. Метод сложения или вычитания
    public static void addOrSubtractAndPrint() {
        int initValue = (int) (Math.random() * 100);
        int delta = (int) (Math.random() * 50);
        boolean increment = Math.random() < 0.5;
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }

}