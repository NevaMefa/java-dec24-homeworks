package ru.otus.java.basic.homeworks.homework21;

public class Massiv {

        public static int[] getElementAfterOne(int[] arr) {
            int lastIndex = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    lastIndex = i;
                }
            }

            if (lastIndex == -1) {
                throw new RuntimeException("Нет ни одной единицы в массиве");
            }

            int[] result = new int[arr.length - lastIndex - 1];
            System.arraycopy(arr, lastIndex + 1, result, 0, result.length);
            return result;
        }


        public static boolean checkArray(int[] arr) {
            boolean hasOne = false;
            boolean hasTwo = false;

            for (int num : arr) {
                if (num == 1) {
                    hasOne = true;
                } else if (num == 2) {
                    hasTwo = true;
                } else {
                    return false;
                }
            }
            return hasOne && hasTwo;
        }
}
