package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2469Test {

    private static Solution2469 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution2469();
    }

    @Test
    @DisplayName("It should return correct values for the example 1")
    void shouldReturnTheArrayForExample1() {
        double celsius = 36.50;
        double[] expected = {309.65000, 97.70000};

        double[] actual = solution.convertTemperature(celsius);

        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    @DisplayName("It should return correct values for the example 2")
    void shouldReturnTheArrayForExample2() {
        double celsius = 122.11;
        double[] expected = {395.26000, 251.79800};

        double[] actual = solution.convertTemperature(celsius);

        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    @DisplayName("It should return correct values for the minimum input value (0)")
    void shouldReturnTheArrayForMinimumInputValue() {
        double celsius = 0;
        double[] expected = {273.15000, 32.00000};

        double[] actual = solution.convertTemperature(celsius);

        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    @DisplayName("It should return correct values for the maximum input value (1000)")
    void shouldReturnTheArrayForMaximumInputValue() {
        double celsius = 1000;
        double[] expected = {1273.15000, 1832.00000};

        double[] actual = solution.convertTemperature(celsius);

        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException for a input below the minimum (-0.00001)")
    void shouldThrowExceptionForInputBelowMinimum() {
        double celsius = -0.00001;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.convertTemperature(celsius));

        String expectedMessage = "expected 'celsius' to have value from 0 to 1000 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException for a input above the maximum (1000.00001)")
    void shouldThrowExceptionForInputAboveMinimum() {
        double celsius = 1000.00001;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.convertTemperature(celsius));

        String expectedMessage = "expected 'celsius' to have value from 0 to 1000 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}