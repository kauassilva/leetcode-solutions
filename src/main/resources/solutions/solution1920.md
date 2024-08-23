# 1920. Build Array from Permutation

Given a **zero-based permutation** `nums` **(0-indexed)**, build an array `ans` of the **same length** where `ans[i] = nums[nums[i]]` for each `0 <= i < nums.length` and return it.

A **zero-based permutation** `nums` is an array of **distinct** integers from `0` to `nums.length - 1` **(inclusive)**.

**Constraints:**
- `1 <= nums.length <= 1000`
- `0 <= nums[i] < nums.length`
- The elements in `nums` are **distinct**.

**Follow-up:** Can you solve it without using an extra space (i.e., `O(1)` memory)?

[Link to the LeetCode](https://leetcode.com/problems/build-array-from-permutation/description/)

## My Solution

````java
public int[] buildArray(int[] nums) {
    validateBuildArray(nums);
    int[] ans = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
        ans[i] = nums[nums[i]];
    }

    return ans;
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution1920.java)



## Method Validation

````java
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
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution1920.java)



### Tests

How to run the tests:

````bash
mvn test -Dtest=Solution1920Test
````

Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/Solution1920Test.java))

| Nº | Description                                                                                                    |
|----|----------------------------------------------------------------------------------------------------------------|
| 1  | It should return the array for the example 1                                                                   |
| 2  | It should return the array for the example 2                                                                   |
| 3  | It should return the same array when the input array contains only one element                                 |
| 4  | It should handle large input array                                                                             |
| 5  | It should throw an IllegalArgumentException when the input array is null                                       |
| 6  | It should throw an IllegalArgumentException when the array length is zero                                      |
| 7  | It should throw an IllegalArgumentException when the array length is greater than 1000                         |
| 8  | It should throw an IllegalArgumentException when the input array contains negative numbers                     |
| 9  | It should throw an IllegalArgumentException where the maximum value is greater than the array length minus one |
| 10 | It should throw an IllegalArgumentException when the input array contains duplicate values                     |

