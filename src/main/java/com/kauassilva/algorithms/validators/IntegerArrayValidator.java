package com.kauassilva.algorithms.validators;

public class IntegerArrayValidator {

    /**
     * <b>Constraints:</b>
     * <ul>
     *     <li>{@code n == nums.length}</li>
     *     <li>{@code 1 <= n <= 1000}</li>
     *     <li>{@code 1 <= nums[i] <= 1000}</li>
     * </ul>
     *
     * @param nums an integer array of length {@code n}
     * @see <a href="https://leetcode.com/problems/concatenation-of-array/description/">
     *     1929. Concatenation of Array</a>
     */
    public static void getConcatenation(int[] nums) {
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
