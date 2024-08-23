package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Solution3190Test {

    private static Solution3190 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution3190();
    }

    @DisplayName("It should return the minimum number of operations correctly")
    @ParameterizedTest(name = "{index} : for {0}")
    @MethodSource("testDataForCorrectReturns")
    void shouldReturnTheMinimumNumberOfOperationsForExample1(int[] nums, int expectedInteger) {
        assertEquals(expectedInteger, solution.minimumOperations(nums));
    }

    @DisplayName("It should throw IllegalArgumentException when")
    @ParameterizedTest(name = "{index} : the array {0}")
    @MethodSource("testDataForExceptions")
    void shouldThrowExceptionForArrayLengthLessThanAllowed(int[] nums, String expectedMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.minimumOperations(nums));

        assertEquals(expectedMessage, exception.getMessage());
    }

    public static Stream<Arguments> testDataForCorrectReturns() {
        int[] nums = new int[50];
        Arrays.fill(nums, 50);

        return Stream.of(
                arguments(new int[] {1, 2, 3, 4}, 3),
                arguments(new int[] {3, 6, 9}, 0),
                arguments(named("the minimum array length and value allowed (1)", new int[] {1}), 1),
                arguments(named("the maximum array length and value allowed (50)", nums), 50)
        );
    }

    public static Stream<Arguments> testDataForExceptions() {
        return Stream.of(
                arguments(named("length is less than allowed (0)", new int[0]),
                        "expected 'nums' to have 1 <= size <= 50 but got 0"),
                arguments(named("length is greater than allowed (51)", new int[51]),
                        "expected 'nums' to have 1 <= size <= 50 but got 51"),
                arguments(named("value is less than allowed (0)", new int[] {0}),
                        "'nums' must consist of values from 1 to 50 only"),
                arguments(named("value is greater than allowed (51)", new int[] {51}),
                        "'nums' must consist of values from 1 to 50 only")
        );
    }

}