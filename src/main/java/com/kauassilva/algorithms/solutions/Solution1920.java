package com.kauassilva.algorithms.solutions;

import java.util.HashSet;
import java.util.Set;

public class Solution1920 {

    public int[] buildArray(int[] nums) {
        validateBuildArray(nums);
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    private void validateBuildArray(int[] nums) {
        validateInputNotNull(nums);
        validateInputLength(nums);
        validateInputValues(nums);
        validateDistinctValues(nums);
    }

    private void validateDistinctValues(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (uniqueNums.contains(num)) {
                throw new IllegalArgumentException("'nums' must consist of distinct values only");
            }

            uniqueNums.add(num);
        }
    }

    private void validateInputNotNull(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("'nums' cannot be null");
        }
    }

    private void validateInputLength(int[] nums) {
        if (nums.length < 1 || nums.length > 1000) {
            throw new IllegalArgumentException("expected 'nums' to have 1 <= size <= 1000 but got " + nums.length);
        }
    }

    private void validateInputValues(int[] nums) {
        for (int num : nums) {
            if (num < 0 || num >= nums.length) {
                throw new IllegalArgumentException("'nums' must consist of values from 0 to " + (nums.length - 1) + " only");
            }
        }
    }

}
