package ru.otus.java.basic.homeworks.homework21;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.java.basic.homeworks.homework21.Massiv.checkArray;
import static ru.otus.java.basic.homeworks.homework21.Massiv.getElementAfterOne;

public class MassivTest {

    @Test
    public void testAfterLastOneNormal() {
        int[] input = {1, 2, 1, 2, 2};
        int[] result = getElementAfterOne(input);
        System.out.println("Результат: " + Arrays.toString(result)); // добавить это
        int[] expected = {2, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAfterLastOneOnlyOne() {
        int[] input = {1, 2, 3, 4, 1, 5, 6};
        int[] result = getElementAfterOne(input);
        System.out.println("Результат: " + Arrays.toString(result));
        int[] expected = {5, 6};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAfterLastOneThrowsException() {
        int[] input = {2, 2, 2};
        System.out.println("ожидаем RuntimeException");
        assertThrows(RuntimeException.class, () -> getElementAfterOne(input));
    }

    @Test
    public void testContainsOnlyOneAndTwoTrue() {
        boolean result1 = checkArray(new int[]{1, 2});
        boolean result2 = checkArray(new int[]{1, 2, 2, 1});
        System.out.println("Результат: " + result1);
        System.out.println("Результат: " + result2);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    public void testContainsOnlyOneAndTwoFalseMissingTwo() {
        boolean result = checkArray(new int[]{1, 1});
        System.out.println("Результат: " + result);
        assertFalse(result);
    }

    @Test
    public void testContainsOnlyOneAndTwoFalseExtraNumber() {
        boolean result1 = checkArray(new int[]{1, 3});
        boolean result2 = checkArray(new int[]{1, 2, 3});
        System.out.println("Результат: " + result1);
        System.out.println("Результат: " + result2);
        assertFalse(result1);
        assertFalse(result2);
    }
}
