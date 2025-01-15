package ru.otus.java.basic.homeworks.homework3;

public class AppHw3 {
    public static void main(String[] args) {
        greetings();
        checkSign(1, 2, -33);
        selectColor();
        compareNumbers();
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
        int data = 21;
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
        if (a >= b){
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }
}
