package ru.otus.java.basic.homeworks.homework5;

public class AppHw5 {
    public static void main(String[] args) {
//        int[][] mas2d = {{1, 1, 1, 1}, {-1, -1, -1, -1}, {1, 1, 1, 1}};
//        int result = sumOfPositiveElements(mas2d);
//        System.out.println("Сумма всех элементов " + result);
//        box(2);
//        forNull(mas2d);
        int[][] array = {{1, 2}, {3, 4,}, {5, 6}};
        System.out.println("Максимальный элемент массива: " + findMax(array));
        System.out.println("Сумма элементов второй строки: " + sumTwoString(array));
    }

    public static int sumTwoString(int[][] array) {
        int sum = 0;
        if (array.length < 2) {
            return -1;
        }
        for (int j = 0; j < array[1].length; j++) {
            sum += array[1][j];
        }
        return sum;
}

public static int findMax(int[][] array) {
    int max = array[0][0];
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            if (array[i][j] > max) {
                max = array[i][j];
            }
        }
    }
    return max;
}

public static void forNull(int[][] mas2d) {
    for (int i = 0; i < mas2d.length; i++) {
        for (int j = 0; j < mas2d[i].length; j++) {
            mas2d[i][i] = 0;
        }
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