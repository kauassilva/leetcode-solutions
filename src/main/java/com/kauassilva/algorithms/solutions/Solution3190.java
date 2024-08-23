package com.kauassilva.algorithms.solutions;

public class Solution3190 {

    public int minimumOperations(int[] nums) {
        validateMinimumOperations(nums);

        int operations = 0;

        for (int num : nums) {
            if (num % 3 != 0) {
                operations++;
            }
        }

        return operations;
    }

    private void validateMinimumOperations(int[] nums) {
        validateInputLength(nums);
        validateInputValues(nums);
    }

    private void validateInputLength(int[] nums) {
        if (nums.length < 1 || nums.length > 50) {
            throw new IllegalArgumentException("expected 'nums' to have 1 <= size <= 50 but got " + nums.length);
        }
    }

    private void validateInputValues(int[] nums) {
        for (int num : nums) {
            if (num < 1 || num > 50) {
                throw new IllegalArgumentException("'nums' must consist of values from 1 to 50 only");
            }
        }
    }

}
