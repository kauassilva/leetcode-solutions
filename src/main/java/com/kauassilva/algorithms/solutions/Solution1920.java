package com.kauassilva.algorithms.solutions;

import java.util.HashSet;
import java.util.Set;

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
public class Solution1920 {

    public static int[] buildArray(int[] nums) {
        validateBuildArray(nums);
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    private static void validateBuildArray(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("'nums' cannot be null");
        }

        if (nums.length < 1 || nums.length > 1000) {
            throw new IllegalArgumentException("expected 'nums' to have 1 <= size <= 1000 but got " + nums.length);
        }

        Set<Integer> uniqueNums = new HashSet<>();

        for (int num : nums) {
            if (num < 0 || num >= nums.length) {
                throw new IllegalArgumentException("'nums' must consist of values from 0 to " + (nums.length - 1) + " only");
            }

            if (uniqueNums.contains(num)) {
                throw new IllegalArgumentException("'nums' must consist of distinct values only");
            }

            uniqueNums.add(num);
        }
    }

}
