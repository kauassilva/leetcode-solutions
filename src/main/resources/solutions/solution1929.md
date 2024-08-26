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
public int[] getConcatenation(int[] nums) {
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
private void validateGetConcatenation(int[] nums) {
    validateInputLength(nums);
    validateInputValues(nums);
}

private void validateInputLength(int[] nums) {
    if (nums.length < 1 || nums.length > 1000) {
        throw new IllegalArgumentException("expected 'nums' to have 1 <= size <= 1000 but got " + nums.length);
    }
}

private void validateInputValues(int[] nums) {
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
mvn test -Dtest=Solution1929Test
````

#### Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/Solution1929Test.java))

- **It should return the concatenation for**
  - 1 : [1, 2, 1]
  - 2 : [1, 3, 2, 1]
  - 3 : the minimum size allowed
  - 4 : the maximum size allowed


- **It should throw IllegalArgumentException when**
  - 1 : the size is less than allowed (0)
  - 2 : the size is greater than allowed (1001)
  - 3 : the value is less than allowed (0)
  - 4 : the value is greater than allowed (1001)
