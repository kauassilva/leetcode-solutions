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

class Solution2469Test {

    private static Solution2469 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution2469();
    }

    @DisplayName("It should return the array correctly for")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForCorrectReturns")
    void shouldReturnTheArrayCorrectly(double celsius, double[] expectedArray) {
        assertArrayEquals(expectedArray, solution.convertTemperature(celsius), 1e-5);
    }

    @DisplayName("It should throw IllegalArgumentException when")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForExceptions")
    void shouldThrowException(double celsius, String expectedMessage) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.convertTemperature(celsius));

        assertEquals(expectedMessage, exception.getMessage());
    }

    public static Stream<Arguments> testDataForCorrectReturns() {
        return Stream.of(
                arguments(36.50, new double[] {309.65000, 97.70000}),
                arguments(122.11, new double[] {395.26000, 251.79800}),
                arguments(named("the minimum input value (0)", 0),
                        new double[] {273.15000, 32.00000}),
                arguments(named("the maximum input value (1000)", 1000),
                        new double[] {1273.15000, 1832.00000})
        );
    }

    public static Stream<Arguments> testDataForExceptions() {
        return Stream.of(
                arguments(named("input value is less than allowed (-0.00001)", -0.00001),
                        "expected 'celsius' to have value from 0 to 1000 only"),
                arguments(named("input value is greater than allowed (1000.00001)", 1000.00001),
                        "expected 'celsius' to have value from 0 to 1000 only")
        );
    }

}