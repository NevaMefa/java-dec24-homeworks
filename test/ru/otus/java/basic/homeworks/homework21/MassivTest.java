package ru.otus.java.basic.homeworks.homework21;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static ru.otus.java.basic.homeworks.homework21.Massiv.checkArray;
import static ru.otus.java.basic.homeworks.homework21.Massiv.getElementAfterOne;

public class MassivTest {
    @ParameterizedTest
    @MethodSource("provideArraysForAfterLastOneNormal")
    public void testAfterLastOneNormal(int[] input, int[] expected) {
        int[] result = getElementAfterOne(input);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> provideArraysForAfterLastOneNormal() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 2, 2}, new int[]{2, 2}),
                Arguments.of(new int[]{1, 2, 3, 4, 1, 5, 6}, new int[]{5, 6})
        );
    }

    @Test
    public void testAfterLastOneOnlyOne() {
        int[] input = {1, 2, 3, 4, 1, 5, 6};

        int[] result = getElementAfterOne(input);

        int[] expected = {5, 6};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAfterLastOneThrowsException() {
        int[] input = {2, 2, 2};

        assertThrows(RuntimeException.class, () -> getElementAfterOne(input));
    }

    @ParameterizedTest
    @MethodSource("provideArraysForCheckArrayTrue")
    public void testContainsOnlyOneAndTwoTrue(int[] input) {
        assertTrue(checkArray(input));
    }

    static Stream<int[]> provideArraysForCheckArrayTrue() {
        return Stream.of(
                new int[]{1, 2},
                new int[]{1, 2, 2, 1}
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysForCheckArrayFalseMissingTwo")
    public void testContainsOnlyOneAndTwoFalseMissingTwo(int[] input) {
        assertFalse(checkArray(input));
    }

    static Stream<int[]> provideArraysForCheckArrayFalseMissingTwo() {
        return Stream.of(
                new int[]{1, 1}
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysForCheckArrayFalseExtraNumber")
    public void testContainsOnlyOneAndTwoFalseExtraNumber(int[] input) {
        assertFalse(checkArray(input));
    }

    static Stream<int[]> provideArraysForCheckArrayFalseExtraNumber() {
        return Stream.of(
                new int[]{1, 3},
                new int[]{1, 2, 3}
        );
    }
}
