# 3190. Find Minimum Operations to Make All Elements Divisible by Three

You are given an integer array `nums`. In one operation, you can add or subtract 1 from **any** element of `nums`.

Return the **minimum** number of operations to make all elements of `nums` divisible by 3.


**Constraints:**
- `1 <= nums.length <= 50`
- `1 <= nums[i] <= 50`


[Link to the LeetCode](https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/)


## My Solution

````java
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
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution3190.java)



## Method Validation

````java
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
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution3190.java)



### Tests

How to run the tests:

````bash
mvn test -Dtest=Solution3190Test
````

Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/Solution3190Test.java))

| Nº | Description                                                                                       |
|----|---------------------------------------------------------------------------------------------------|
| 1  | It should return the minimum number of operations for example 1                                   |
| 2  | It should return the minimum number of operations for example 2                                   |
| 3  | It should return the minimum number of operations for the minimum array length and value allowed  |
| 4  | It should return the minimum number of operations for the maximum array length and values allowed |
| 5  | It should throw IllegalArgumentException when the input array length is less than allowed         |
| 6  | It should throw IllegalArgumentException when the input array length is greater than allowed      |
| 7  | It should throw IllegalArgumentException when the array value is less than allowed                |
| 8  | It should throw IllegalArgumentException when the array value is greater than allowed             |
