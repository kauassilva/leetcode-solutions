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

class Solution2769Test {

    private static Solution2769 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution2769();
    }

    @DisplayName("It should return the maximum achievable number for")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForCorrectReturns")
    void shouldReturnTheMaximumAchievableNumberForExample1(int num, int t, int expectedInteger) {
        assertEquals(expectedInteger, solution.theMaximumAchievableX(num, t));
    }

    @DisplayName("It should throw IllegalArgumentException when")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForExceptions")
    void shouldThrowExceptionForNumLessThan1(int num, int t, String expectedMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.theMaximumAchievableX(num, t));

        assertEquals(expectedMessage, exception.getMessage());
    }

    public static Stream<Arguments> testDataForCorrectReturns() {
        return Stream.of(
                arguments(named("num = 4 and t = 1", 4), 1, 6),
                arguments(named("num = 3 and t = 2", 3), 2, 7),
                arguments(named("the minimum values allowed", 1), 1, 3),
                arguments(named("the maximum values allowed", 50), 50, 150)
        );
    }

    public static Stream<Arguments> testDataForExceptions() {
        return Stream.of(
                arguments(named("the 'num' is less than 1 (0)", 0), 1,
                        "expected 'num' to have value from 1 to 50 only"),
                arguments(named("the 'num' is greater than 50 (51)", 51), 1,
                        "expected 'num' to have value from 1 to 50 only"),
                arguments(named("the 't' is less than 1 (0)", 1), 0,
                        "expected 't' to have value from 1 to 50 only"),
                arguments(named("the 't' is greater than 50 (51)", 1), 0,
                        "expected 't' to have value from 1 to 50 only")
        );
    }

}