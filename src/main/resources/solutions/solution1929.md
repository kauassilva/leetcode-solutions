# 1929. Concatenation of Array

Given an integer array `nums` of length `n`, you want to create an array `ans` of length `2n` where
`ans[i] == nums[i]` and `ans[i + n] == nums[i]` for `0 <= i < n` **(0-indexed)**.

Specifically, `ans` is the **concatenation** of two `nums` arrays.

Return *the array* `ans`.

**Constraints:**
- `n == nums.length`
- `1 <= n <= 1000`
- `1 <= nums[i] <= 1000`

[Link to the LeetCode](https://leetcode.com/problems/concatenation-of-array/description/)


## My Solution

````java
public static int[] getConcatenation(int[] nums) {
    validateGetConcatenation(nums);
    int n = nums.length;
    int[] ans = Arrays.copyOf(nums, n*2);
    System.arraycopy(nums, 0, ans, n, n);
    return ans;
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution1929.java)



## Method Validation

````java
private static void validateGetConcatenation(int[] nums) {
    validateInputLength(nums);
    validateInputValues(nums);
}

private static void validateInputLength(int[] nums) {
    if (nums.length < 1 || nums.length > 1000) {
        throw new IllegalArgumentException("expected 'nums' to have 1 <= size <= 1000 but got" + nums.length);
    }
}

private static void validateInputValues(int[] nums) {
    for (int num : nums) {
        if (num < 1 || num > 1000) {
            throw new IllegalArgumentException("'nums' must consist of values from 1 to 1000 only");
        }
    }
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution1929.java)



### Tests

How to run the tests:

````bash
mvn test -Dtest=SolutionTest
````

Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/Solution1929Test.java))

| Nº | Description                                                                                   |
|----|-----------------------------------------------------------------------------------------------|
| 1  | It should return the array for the example 1                                                  |
| 2  | It should return the array for the example 2                                                  |
| 3  | It should return the concatenation to the minimum allowed size of 'nums'                      |
| 4  | It should return the concatenation to the maximum allowed size of 'nums'                      |
| 5  | It should throw an IllegalArgumentException when the allowed size of 'nums' is less than 1    |
| 6  | It should throw an IllegalArgumentException when the allowed size of 'nums' is greater than 1 |
| 7  | It should throw an IllegalArgumentException when the value of 'nums' is less than 1           |
| 8  | It should throw an IllegalArgumentException when the value of 'nums' is greater than 1000     |
