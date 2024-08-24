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

class Solution1929Test {

    private static Solution1929 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution1929();
    }

    @DisplayName("It should return the concatenation correctly for")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForCorrectReturns")
    void shouldReturnConcatenationCorrectly(int[] nums, int[] expectedArray) {
        assertArrayEquals(expectedArray, solution.getConcatenation(nums));
    }

    @DisplayName("It should throw IllegalArgumentException when")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForExceptions")
    void shouldThrowException(int[] nums, String expectedMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.getConcatenation(nums));

        assertEquals(expectedMessage, exception.getMessage());
    }

    public static Stream<Arguments> testDataForCorrectReturns() {
        int[] maxNums = new int[1000];
        int[] maxExpectedArray = new int[maxNums.length * 2];

        for (int i=0; i<maxNums.length; i++) {
            maxNums[i] = i+1;
            maxExpectedArray[i] = i+1;
            maxExpectedArray[i+maxNums.length] = i+1;
        }

        return Stream.of(
                arguments(new int[] {1, 2, 1}, new int[] {1, 2, 1, 1, 2, 1}),
                arguments(new int[] {1, 3, 2, 1}, new int[] {1, 3, 2, 1, 1, 3, 2, 1}),
                arguments(named("the minimum size allowed", new int[] {1}), new int[] {1, 1}),
                arguments(named("the maximum size allowed", maxNums), maxExpectedArray)
        );
    }

    public static Stream<Arguments> testDataForExceptions() {
        return Stream.of(
                arguments(named("the size is less than allowed (0)", new int[0]),
                        "expected 'nums' to have 1 <= size <= 1000 but got 0"),
                arguments(named("the size is greater than allowed (1001)", new int[1001]),
                        "expected 'nums' to have 1 <= size <= 1000 but got 1001"),
                arguments(named("the value is less than allowed (0)", new int[] {0}),
                        "'nums' must consist of values from 1 to 1000 only"),
                arguments(named("the value is greater than allowed (1001)", new int[] {1001}),
                        "'nums' must consist of values from 1 to 1000 only")
        );
    }

}