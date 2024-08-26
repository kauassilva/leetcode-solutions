package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Solution1920Test {

    private static Solution1920 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution1920();
    }

    @DisplayName("It should return the array correctly for")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForCorrectReturns")
    void shouldReturnArrayCorrectly(int[] nums, int[] expectedArray) {
        assertArrayEquals(expectedArray, solution.buildArray(nums));
    }

    @DisplayName("It should throw IllegalArgumentException when")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForExceptions")
    void shouldThrowException(int[] nums, String expectedMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.buildArray(nums));

        assertEquals(expectedMessage, exception.getMessage());
    }

    public static Stream<Arguments> testDataForCorrectReturns() {
        int[] largeNums = new int[1000];
        int[] largeExpected = new int[1000];

        for (int i = 0; i < largeNums.length; i++) {
            largeNums[i] = i;
            largeExpected[i] = largeNums[largeNums[i]];
        }

        return Stream.of(
                arguments(new int[] {0, 2, 1, 5, 3, 4}, new int[] {0, 1, 2, 4, 5, 3}),
                arguments(new int[] {5, 0, 1, 2, 3, 4}, new int[] {4, 5, 0, 1, 2, 3}),
                arguments(named("the array containing only one element", new int[] {0}), new int[] {0}),
                arguments(named("a large input array", largeNums), largeExpected)
        );
    }

    public static Stream<Arguments> testDataForExceptions() {
        return Stream.of(
                arguments(named("the array is null", null), "'nums' cannot be null"),
                arguments(named("the array length is zero", new int[0]),
                        "expected 'nums' to have 1 <= size <= 1000 but got 0"),
                arguments(named("the array length is greater than 1000", new int[1001]),
                        "expected 'nums' to have 1 <= size <= 1000 but got 1001"),
                arguments(named("the array contains negative numbers", new int[] {0, -1, 1, 2, 3, 4}),
                        "'nums' must consist of values from 0 to 5 only"),
                arguments(named("the maximum array value is greater than the length minus one", new int[] {0, 1, 3, 1001}),
                        "'nums' must consist of values from 0 to 3 only"),
                arguments(named("the input array contains duplicate values", new int[] {0, 2, 1, 5, 3, 4, 2}),
                        "'nums' must consist of distinct values only")
        );
    }

}