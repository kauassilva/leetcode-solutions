package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Solution3110Test {

    private static Solution3110 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution3110();
    }

    @DisplayName("It should return the score of the string correctly")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForCorrectReturns")
    void shouldReturnScoreForHelloString(String s, int expectedInteger) {
        assertEquals(expectedInteger, solution.scoreOfString(s));
    }

    @DisplayName("It should throw IllegalArgumentException when")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForExceptions")
    void shouldThrowExceptionForShortString(String s, String expectedMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.scoreOfString(s));

        assertEquals(expectedMessage, exception.getMessage());
    }

    public static Stream<Arguments> testDataForCorrectReturns() {
        return Stream.of(
                arguments("hello", 13),
                arguments("zaz", 50),
                arguments(named("with 2 characters", "jx"), 14),
                arguments(named("with 100 characters", "bqjxwzvqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqy"), 811)
        );
    }

    public static Stream<Arguments> testDataForExceptions() {
        return Stream.of(
            arguments(named("the length of the string is less than 2 characters (1)", "x"),
                    "Expected 's' to have 2 <= size >= 100 but got 1."),
            arguments(named("the length of the string is greater than 100 characters (101)", "bqjxwzvqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyr"),
                    "Expected 's' to have 2 <= size >= 100 but got 101."),
            arguments(named("the string contains an uppercase character", "azA"),
                    "'s' must consist of values from a to z only")
        );
    }

}