package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1929Test {

    @Test
    @DisplayName("It should return the concatenation for the example 1")
    void shouldReturnConcatenationForExample1() {
        int[] nums = {1, 2, 1};
        int[] expected = {1, 2, 1, 1, 2, 1};

        int[] output = Solution1929.getConcatenation(nums);

        assertArrayEquals(expected, output);
    }

    @Test
    @DisplayName("It should return the concatenation for the example 2")
    void shouldReturnConcatenationForExample2() {
        int[] nums = {1, 3, 2, 1};
        int[] expected = {1, 3, 2, 1, 1, 3, 2, 1};

        int[] output = Solution1929.getConcatenation(nums);

        assertArrayEquals(expected, output);
    }

    @Test
    @DisplayName("It should return the concatenation to the minimum allowed size of 'nums'")
    void shouldReturnConcatenationToTheMinimumAllowedSize() {
        int[] nums = {1};
        int[] expected = {1, 1};

        int[] output = Solution1929.getConcatenation(nums);

        assertArrayEquals(expected, output);
    }

    @Test
    @DisplayName("It should return the concatenation to the maximum allowed size of 'nums'")
    void shouldReturnConcatenationToTheMaximumAllowedSize() {
        int maximumSize = 1000;
        int[] nums = new int[maximumSize];
        int[] expected = new int[maximumSize*2];

        for (int i=0; i<maximumSize; i++) {
            nums[i] = i+1;
            expected[i] = i+1;
            expected[i+maximumSize] = i+1;
        }

        int[] output = Solution1929.getConcatenation(nums);

        assertArrayEquals(expected, output);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the allowed size of 'nums' is less than 1")
    void shouldThrowExceptionForNumsSizeLessThan1() {
        int[] nums = new int[0];

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution1929.getConcatenation(nums));

        String expectedMessage = "expected 'nums' to have 1 <= size <= 1000 but got" + nums.length;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the allowed size of 'nums' is greater than 1")
    void shouldThrowExceptionForNumsSizeGreaterThan1000() {
        int[] nums = new int[1001];

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution1929.getConcatenation(nums));

        String expectedMessage = "expected 'nums' to have 1 <= size <= 1000 but got" + nums.length;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the value of 'nums' is less than 1")
    void shouldThrowExceptionForNumsValueLessThan1() {
        int[] nums = {0};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution1929.getConcatenation(nums));

        String expectedMessage = "'nums' must consist of values from 1 to 1000 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the value of 'nums' is greater than 1000")
    void shouldThrowExceptionForNumsValueGreaterThan1000() {
        int[] nums = {1001};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution1929.getConcatenation(nums));

        String expectedMessage = "'nums' must consist of values from 1 to 1000 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}