# 3190. Find Minimum Operations to Make All Elements Divisible by Three

You are given an integer array `nums`. In one operation, you can add or subtract 1 from **any** element of `nums`.

Return the **minimum** number of operations to make all elements of `nums` divisible by 3.


**Constraints:**
- `1 <= nums.length <= 50`
- `1 <= nums[i] <= 50`


[Link to the LeetCode](https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/)


## My Solution

````java
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
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution3190.java)



## Method Validation

````java
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
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution3190.java)



### Tests

How to run the tests:

````bash
mvn test -Dtest=Solution3190Test
````

#### Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/Solution3190Test.java))

- **It should return the minimum number of operations correctly for**
  - 1 : [1, 2, 3, 4]
  - 2 : [3, 6, 9]
  - 3 : the minimum array length and value allowed (1)
  - 4 : the maximum array length and values allowed (50) 
  

- **It should throw IllegalArgumentException when**
  - 1 : the array length is less than allowed (0)
  - 2 : the array length is greater than allowed (51)
  - 3 : the array value is less than allowed (0)
  - 4 : the array value is greater than allowed (51)
