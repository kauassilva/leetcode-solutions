package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Solution2769Test {

    @Test
    @DisplayName("It should return the maximum achievable number for 'num=4' and 't=1'")
    void shouldReturnTheMaximumAchievableNumberForExample1() {
        int num = 4;
        int t = 1;

        assertEquals(6, Solution2769.theMaximumAchievableX(num, t));
    }

    @Test
    @DisplayName("It should return the maximum achievable number for 'num=3' and 't=2'")
    void shouldReturnTheMaximumAchievableNumberForExample2() {
        int num = 3;
        int t = 2;

        assertEquals(7, Solution2769.theMaximumAchievableX(num, t));
    }

    @Test
    @DisplayName("It should return the maximum achievable number to the minimum allowed values")
    void shouldReturnTheMaximumAchievableNumberToTheMinimumAllowed() {
        int num = 1;
        int t = 1;

        assertEquals(3, Solution2769.theMaximumAchievableX(num, t));
    }

    @Test
    @DisplayName("It should return the maximum achievable number to the maximum allowed values")
    void shouldReturnTheMaximumAchievableNumberToTheMaximumAllowed() {
        int num = 50;
        int t = 50;

        assertEquals(150, Solution2769.theMaximumAchievableX(num, t));
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException when the 'num' is less than 1")
    void shouldThrowExceptionForNumLessThan1() {
        int num = 0;
        int t = 1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution2769.theMaximumAchievableX(num, t));

        String expectedMessage = "expected 'num' to have value from 1 to 50 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException when the 'num' is greater than 50")
    void shouldThrowExceptionForNumGreaterThan50() {
        int num = 51;
        int t = 1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution2769.theMaximumAchievableX(num, t));

        String expectedMessage = "expected 'num' to have value from 1 to 50 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException when the 't' is less than 1")
    void shouldThrowExceptionForTLessThan1() {
        int num = 1;
        int t = 0;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution2769.theMaximumAchievableX(num, t));

        String expectedMessage = "expected 't' to have value from 1 to 50 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException when the 't' is greater than 50")
    void shouldThrowExceptionForTGreaterThan50() {
        int num = 1;
        int t = 51;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution2769.theMaximumAchievableX(num, t));

        String expectedMessage = "expected 't' to have value from 1 to 50 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}