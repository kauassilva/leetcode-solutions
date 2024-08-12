package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 * You are given an integer array {@code nums}. In one operation, you can add
 * or subtract 1 from <b>any</b> element of {@code nums}.
 *
 * <p>
 * Return the <b>minimum</b> number of operations to make all elements of {@code nums} divisible by 3.
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code 1 <= nums.length <= 50}</li>
 *     <li>{@code 1 <= nums[i] <= 50}</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/">
 *     3190. Find Minimum Operations to Make All Elements Divisible by Three</a>
 */
class Solution3190Test {

    @Test
    @DisplayName("It should return the minimum number of operations for example 1")
    void shouldReturnTheMinimumNumberOfOperationsForExample1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 3;

        int actual = Solution3190.minimumOperations(nums);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the minimum number of operations for example 2")
    void shouldReturnTheMinimumNumberOfOperationsForExample2() {
        int[] nums = {3, 6, 9};
        int expected = 0;

        int actual = Solution3190.minimumOperations(nums);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the minimum number of operations for the minimum array length and value allowed")
    void shouldReturnTheMinimumNumberForTheMinimumCaseAllowed() {
        int[] nums = {1};
        int expected = 1;

        int actual = Solution3190.minimumOperations(nums);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the minimum number of operations for the maximum array length and values allowed")
    void shouldReturnTheMinimumNumberForTheMaximumCaseAllowed() {
        int maximumLength = 50;
        int[] nums = new int[maximumLength];

        for (int i = 0; i < maximumLength; i++) {
            nums[i] = i+1;
        }

        int expected = 34;

        int actual = Solution3190.minimumOperations(nums);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException when the input array length is less than allowed")
    void shouldThrowExceptionForArrayLengthLessThanAllowed() {
        int[] nums = {};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution3190.minimumOperations(nums));

        String expectedMessage = "expected 'nums' to have 1 <= size <= 50 but got 0";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException when the input array length is greater than allowed")
    void shouldThrowExceptionForArrayLengthGreaterThanAllowed() {
        int[] nums = new int[51];

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution3190.minimumOperations(nums));

        String expectedMessage = "expected 'nums' to have 1 <= size <= 50 but got 51";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException when the array value is less than allowed")
    void shouldThrowExceptionForArrayValueLessThanAllowed() {
        int[] nums = {0};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution3190.minimumOperations(nums));

        String expectedMessage = "'nums' must consist of values from 1 to 50 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException when the array value is greater than allowed")
    void shouldThrowExceptionForArrayValueGreaterThanAllowed() {
        int[] nums = {51};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution3190.minimumOperations(nums));

        String expectedMessage = "'nums' must consist of values from 1 to 50 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}