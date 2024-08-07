package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 * Given a <b>zero-based permutation</b> {@code nums} <b>(0-indexed)</b>, build
 * an array {@code ans} of the <b>same length</b> where {@code ans[i] =
 * nums[nums[i]]} for each {@code 0 <= i < nums.length} and return it.
 *
 * <p>
 * A <b>zero-based permutation</b> {@code nums} is an array of <b>distinct</b>
 * integers from {@code 0} to {@code nums.length - 1} <b>(inclusive)</b>.
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code 1 <= nums.length <= 1000}</li>
 *     <li>{@code 0 <= nums[i] < nums.length}</li>
 *     <li>The elements in {@code nums} are <b>distinct</b>.</li>
 * </ul>
 *
 * <p>
 * <b>Follow-up:</b> Can you solve it without using an extra space (i.e.,
 * {@code O(1)} memory)?
 *
 * @see <a href="https://leetcode.com/problems/build-array-from-permutation/description/">
 *     1920. Build Array from Permutation</a>
 */
class Solution1920Test {

    @Test
    @DisplayName("It should return the array for the example 1")
    void shouldReturnArrayForExample1() {
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] expected = {0, 1, 2, 4, 5, 3};

        int[] actual = Solution1920.buildArray(nums);

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the array for the example 2")
    void shouldReturnArrayForExample2() {
        int[] nums = {5, 0, 1, 2, 3, 4};
        int[] expected = {4, 5, 0, 1, 2, 3};

        int[] actual = Solution1920.buildArray(nums);

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the same array when the input array contains only one element")
    void shouldReturnArrayForSingleElement() {
        int[] nums = {0};
        int[] expected = {0};

        int[] actual = Solution1920.buildArray(nums);

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("It should handle large input array")
    void shouldHandlesLargeInputArray() {
        int[] nums = new int[1000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        int[] actual = Solution1920.buildArray(nums);

        for (int i = 0; i < nums.length; i++) {
            assertEquals(nums[nums[i]], actual[i]);
        }
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the input array is null")
    void shouldThrowExceptionForNullArray() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution1920.buildArray(null));

        String expectedMessage = "'nums' cannot be null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the array length is zero")
    void shouldThrowExceptionForZeroLengthArray() {
        int[] nums = new int[0];

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution1920.buildArray(nums));

        String expectedMessage = "expected 'nums' to have 1 <= size <= 1000 but got " + nums.length;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the array length is greater than 1000")
    void shouldThrowExceptionForArrayLengthGreaterThan1000() {
        int[] nums = new int[1001];

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution1920.buildArray(nums));

        String expectedMessage = "expected 'nums' to have 1 <= size <= 1000 but got " + nums.length;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the input array contains negative numbers")
    void shouldThrowExceptionForNegativeNumbers() {
        int[] nums = {0, -1, 1, 2, 3, 4};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution1920.buildArray(nums));

        String expectedMessage = "'nums' must consist of values from 0 to " + (nums.length - 1) + " only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException where the maximum value is greater than the array length minus one")
    void shouldThrowExceptionForMaxValueGreaterThanArrayLengthMinusOne() {
        int[] nums = {0, 1, 3, 1001};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution1920.buildArray(nums));

        String expectedMessage = "'nums' must consist of values from 0 to " + (nums.length - 1) + " only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the input array contains duplicate values")
    void shouldThrowExceptionForDuplicateValues() {
        int[] nums = {0, 2, 1, 5, 3, 4, 2};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution1920.buildArray(nums));

        String expectedMessage = "'nums' must consist of distinct values only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }


}