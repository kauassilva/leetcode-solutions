package com.kauassilva.algorithms.solutions;

import java.util.Arrays;

/**
 * <p>
 * Given an integer array {@code nums} of length{@code n}, you want to create an array {@code ans} of length {@code 2n} where
 * {@code ans[i] == nums[i]} and {@code ans[i + n] == nums[i]} for
 * {@code 0 <= i < n} <b>(0-indexed)</b>.
 *
 * <p>
 * Specifically, {@code ans} is the <b>concatenation</b> of two
 * {@code nums} arrays.
 *
 * <p>
 * Return <i>the array</i> {@code ans}.
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code n == nums.length}</li>
 *     <li>{@code 1 <= n <= 1000}</li>
 *     <li>{@code 1 <= nums[i] <= 1000}</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/concatenation-of-array/description/">
 *     1929. Concatenation of Array</a>
 */
public class GetConcatenation {

    public static int[] getConcatenation(int[] nums) {
        validateGetConcatenation(nums);
        int n = nums.length;
        int[] ans = Arrays.copyOf(nums, n*2);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }

    private static void validateGetConcatenation(int[] nums) {
        if (nums.length < 1 || nums.length > 1000) {
            throw new IllegalArgumentException("expected 'nums' to have 1 <= size <= 1000 but got" + nums.length);
        }

        for (int num : nums) {
            if (num < 1 || num > 1000) {
                throw new IllegalArgumentException("'nums' must consist of values from 1 to 1000 only");
            }
        }
    }

}
