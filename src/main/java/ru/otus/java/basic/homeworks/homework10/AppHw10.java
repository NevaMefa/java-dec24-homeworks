class AppArraySizeException extends IllegalArgumentException {
    public AppArraySizeException(String s) {
        super("Массив должен быть 4x4");
    }
}

class AppArrayDataException extends NumberFormatException {
    public AppArrayDataException(int row, int col) {
        super("Ошибка в ячейке: [" + row + "][" + col + "]");
    }
}

public class AppHw10 {

    public static void main(String[] args) {
        String[][] tryArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidArray1 = {
                {"1", "2", "3", "4"},
                {"5", "X", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Сумма: " + checkArrayLenght(tryArray));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("Сумма: " + checkArrayLenght(invalidArray1));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int checkArrayLenght(String[][] array) {
        if (array.length != 4) {
            throw new AppArraySizeException("Массив должен быть 4х4");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new AppArraySizeException("Массив должен быть 4х4");
            }
        }
        System.out.println("Передан массив корректной длины");
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(String.valueOf(array[i][j]));
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
