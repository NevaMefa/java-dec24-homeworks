package ru.otus.java.basic.homeworks.homework5;

public class AppHw5 {
    public static void main(String[] args) {
        int[][] mas2d = {{1, 1, 1}, {-1, -1, -1},{1, 1, 1}} ;
    }

    public static int sumOfPositiveElements(int[][] mas2d) {
        int sum = 0;
        for (int i = 0; i < mas2d.length; i++) {
            if (mas2d[i][i] > 0) {
                sum += mas2d[i][i];
            }
            System.out.println(sum);
        }
        return sum;
    }
}