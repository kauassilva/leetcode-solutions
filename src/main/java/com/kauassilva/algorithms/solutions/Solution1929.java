package com.kauassilva.algorithms.solutions;

import java.util.Arrays;

public class Solution1929 {

    public int[] getConcatenation(int[] nums) {
        validateGetConcatenation(nums);
        int n = nums.length;
        int[] ans = Arrays.copyOf(nums, n*2);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }

    private void validateGetConcatenation(int[] nums) {
        validateInputLength(nums);
        validateInputValues(nums);
    }

    private void validateInputLength(int[] nums) {
        if (nums.length < 1 || nums.length > 1000) {
            throw new IllegalArgumentException("expected 'nums' to have 1 <= size <= 1000 but got" + nums.length);
        }
    }

    private void validateInputValues(int[] nums) {
        for (int num : nums) {
            if (num < 1 || num > 1000) {
                throw new IllegalArgumentException("'nums' must consist of values from 1 to 1000 only");
            }
        }
    }

}
