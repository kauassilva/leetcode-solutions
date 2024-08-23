package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1920Test {

    private static Solution1920 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution1920();
    }

    @Test
    @DisplayName("It should return the array for the example 1")
    void shouldReturnArrayForExample1() {
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] expected = {0, 1, 2, 4, 5, 3};

        int[] actual = solution.buildArray(nums);

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the array for the example 2")
    void shouldReturnArrayForExample2() {
        int[] nums = {5, 0, 1, 2, 3, 4};
        int[] expected = {4, 5, 0, 1, 2, 3};

        int[] actual = solution.buildArray(nums);

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the same array when the input array contains only one element")
    void shouldReturnArrayForSingleElement() {
        int[] nums = {0};
        int[] expected = {0};

        int[] actual = solution.buildArray(nums);

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("It should handle large input array")
    void shouldHandlesLargeInputArray() {
        int[] nums = new int[1000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        int[] actual = solution.buildArray(nums);

        for (int i = 0; i < nums.length; i++) {
            assertEquals(nums[nums[i]], actual[i]);
        }
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the input array is null")
    void shouldThrowExceptionForNullArray() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.buildArray(null));

        String expectedMessage = "'nums' cannot be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the array length is zero")
    void shouldThrowExceptionForZeroLengthArray() {
        int[] nums = new int[0];

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.buildArray(nums));

        String expectedMessage = "expected 'nums' to have 1 <= size <= 1000 but got " + nums.length;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the array length is greater than 1000")
    void shouldThrowExceptionForArrayLengthGreaterThan1000() {
        int[] nums = new int[1001];

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.buildArray(nums));

        String expectedMessage = "expected 'nums' to have 1 <= size <= 1000 but got " + nums.length;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the input array contains negative numbers")
    void shouldThrowExceptionForNegativeNumbers() {
        int[] nums = {0, -1, 1, 2, 3, 4};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.buildArray(nums));

        String expectedMessage = "'nums' must consist of values from 0 to " + (nums.length - 1) + " only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException where the maximum value is greater than the array length minus one")
    void shouldThrowExceptionForMaxValueGreaterThanArrayLengthMinusOne() {
        int[] nums = {0, 1, 3, 1001};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> solution.buildArray(nums));

        String expectedMessage = "'nums' must consist of values from 0 to " + (nums.length - 1) + " only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the input array contains duplicate values")
    void shouldThrowExceptionForDuplicateValues() {
        int[] nums = {0, 2, 1, 5, 3, 4, 2};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.buildArray(nums));

        String expectedMessage = "'nums' must consist of distinct values only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}