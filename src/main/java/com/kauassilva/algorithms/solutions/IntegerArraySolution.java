package com.kauassilva.algorithms.solutions;

import com.kauassilva.algorithms.validators.IntegerArrayValidator;

import java.util.Arrays;

public class IntegerArraySolution {

    /**
     * <p>
     * You want to create an array {@code ans} of length {@code 2n} where
     * {@code ans[i] == nums[i]} and {@code ans[i + n] == nums[i]} for
     * {@code 0 <= i < n} <b>(0-indexed)</b>.
     *
     * <p>
     * Specifically, {@code ans} is the <b>concatenation</b> of two
     * {@code nums} arrays.
     *
     * <p>
     * <b>Constraints:</b>
     * <ul>
     *     <li>{@code n == nums.length}</li>
     *     <li>{@code 1 <= n <= 1000}</li>
     *     <li>{@code 1 <= nums[i] <= 1000}</li>
     * </ul>
     *
     * @param nums an integer of length {@code n}
     * @return the array {@code ans}
     * @see <a href="https://leetcode.com/problems/concatenation-of-array/description/">
     *     1929. Concatenation of Array</a>
     */
    public static int[] getConcatenation(int[] nums) {
        IntegerArrayValidator.getConcatenation(nums);
        int n = nums.length;
        int[] ans = Arrays.copyOf(nums, n*2);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }

}
