package ru.otus.java.basic.homeworks.homework5;

public class AppHw5 {
    public static void main(String[] args) {
        int[][] mas2d = {{1, 1, 1, 1}, {-1, -1, -1, -1}, {1, 1, 1, 1}};
//        int result = sumOfPositiveElements(mas2d);
//        System.out.println("Cymma " + result);
//        box(2);
        forNull(mas2d);
    }

    public static void forNull(int[][] mas2d) {
        for (int i = 0; i < mas2d.length; i++) {
            for (int j = 0; j < mas2d[i].length; j++) {
                mas2d[i][i] = 0;
                System.out.print(mas2d[i][j]);
            }
            System.out.println();
        }
    }

    public static int sumOfPositiveElements(int[][] mas2d) {
        int sum = 0;
        for (int i = 0; i < mas2d.length; i++) {
            for (int j = 0; j < mas2d[i].length; j++) {
                if (mas2d[i][j] > 0) {
                    sum += mas2d[i][j];
                }
            }
        }
        return sum;
    }

    public static void box(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}