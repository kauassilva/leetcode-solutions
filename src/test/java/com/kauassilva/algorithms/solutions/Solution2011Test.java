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

class Solution2011Test {

    private static Solution2011 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution2011();
    }

    @DisplayName("It should return the final value of `X` correctly for")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForCorrectReturns")
    void shouldReturnFinalValueOfXCorrectly(String[] operations, int expectedInteger) {
        assertEquals(expectedInteger, solution.finalValueAfterOperations(operations));
    }

    public static Stream<Arguments> testDataForCorrectReturns() {
        String[] maxOperations = new String[100];
        Arrays.fill(maxOperations, "X++");

        return Stream.of(
                arguments(named("\"--X\", \"X++\", \"X++\"", new String[] {"--X", "X++", "X++"}), 1),
                arguments(named("\"++X\", \"++X\", \"X++\"", new String[] {"++X", "++X", "X++"}), 3),
                arguments(named("\"X++\", \"++X\", \"--X\", \"X--\"", new String[] {"X++", "++X", "--X", "X--"}), 0),
                arguments(named("the operations array with only one operation", new String[] {"++X"}), 1),
                arguments(named("the operations array with the maximum length allowed (100)", maxOperations), 100)
        );
    }

    @DisplayName("It should throw IllegalArgumentException when")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForExceptions")
    void shouldThrowExceptionWhenInputThereAreNoOperations(String[] operations, String expectedMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.finalValueAfterOperations(operations));

        assertEquals(expectedMessage, exception.getMessage());
    }

    public static Stream<Arguments> testDataForExceptions() {
        String[] maxOperations = new String[101];
        Arrays.fill(maxOperations, "X++");

        return Stream.of(
                arguments(named("there are no operations", new String[] {}),
                        "expected 'operations' to have 1 <= size <= 100 but got 0"),
                arguments(named("the input length is above the maximum", maxOperations),
                        "expected 'operations' to have 1 <= size <= 100 but got 101"),
                arguments(named("the input value is different from allowed", new String[] {"+X", "x+", "-x", "x-", "az"}),
                        "'operations' must consist of values in ['X++', 'X--', '++X', '--X'] only")
        );
    }

}