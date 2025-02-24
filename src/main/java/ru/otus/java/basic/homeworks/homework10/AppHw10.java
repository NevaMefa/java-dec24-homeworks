package ru.otus.java.basic.homeworks.homework10;

class AppArraySizeException extends IllegalArgumentException {
    public AppArraySizeException(String s) {
        super("Массив должен быть 4x4");
    }
}

public class AppHw10 {
    public static void main(String[] args) {
        int[][] tryArray = {{1, 1, 1, 4}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 2, 1, 3}};
        int[][] invalidArray1 = {{1, 1, 4}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 2, 1, 3}};
        int[][] invalidArray = {{1, 2}, {1, 2}, {1, 2}};
        checkArrayLenght(tryArray);
//        checkArrayLenght(invalidArray1);
//        checkArrayLenght(invalidArray);
    }


    public static void checkArrayLenght(int[][] array) {
        if (array.length != 4) {
            throw new AppArraySizeException("Массив должен быть 4х4");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new AppArraySizeException("Массив должен быть 4х4");
            }
        }
        System.out.println("Передан массив корректной длины");
    }
}
