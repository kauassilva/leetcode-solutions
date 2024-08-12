package com.kauassilva.algorithms.solutions;

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
public class Solution3190 {

    public static int minimumOperations(int[] nums) {
        validateMinimumOperations(nums);

        int operations = 0;

        for (int num : nums) {
            if (num % 3 != 0) {
                operations++;
            }
        }

        return operations;
    }

    private static void validateMinimumOperations(int[] nums) {
        validateInputLength(nums);
        validateInputValues(nums);
    }

    private static void validateInputLength(int[] nums) {
        if (nums.length < 1 || nums.length > 50) {
            throw new IllegalArgumentException("expected 'nums' to have 1 <= size <= 50 but got " + nums.length);
        }
    }

    private static void validateInputValues(int[] nums) {
        for (int num : nums) {
            if (num < 1 || num > 50) {
                throw new IllegalArgumentException("'nums' must consist of values from 1 to 50 only");
            }
        }
    }

}
