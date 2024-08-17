# 2769. Find the Maximum Achievable Number

Given two integers, `num` and `t`. A **number is achievable** if it can become equal to `num` after applying the following operation:
- Increase or decrease the number by 1, and simultaneously increase or decrease num by 1.

Return the **maximum achievable number** after applying the operation at most `t` times.


**Constraints:**
- `1 <= num, t <= 50`


[Link to the LeetCode](https://leetcode.com/problems/find-the-maximum-achievable-number/description/)

## My Solution

````java
public static int theMaximumAchievableX(int num, int t) {
    validateTheMaximumAchievableX(num, t);
    int maximumAchievable = num;

    for (int i=0; i<t; i++) {
        maximumAchievable+=2;
    }

    return maximumAchievable;
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution2769.java)



## Method Validation

````java
private static void validateTheMaximumAchievableX(int num, int t) {
    validateNumValue(num, "expected 'num' to have value from 1 to 50 only");
    validateNumValue(t, "expected 't' to have value from 1 to 50 only");
}

private static void validateNumValue(int num, String s) {
    if (num < 1 || num > 50) {
        throw new IllegalArgumentException(s);
    }
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution2769.java)



### Tests

How to run the tests:

````bash
mvn test -Dtest=Solution2769Test
````

Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/Solution2769Test.java))

| Nº | Description                                                                  |
|----|------------------------------------------------------------------------------|
| 1  | It should return the maximum achievable number for 'num=4' and 't=1'         |
| 2  | It should return the maximum achievable number for 'num=3' and 't=2'         |
| 3  | It should return the maximum achievable number to the minimum allowed values |
| 4  | It should return the maximum achievable number to the maximum allowed values |
| 5  | It should throw IllegalArgumentException when the 'num' is less than 1       |
| 6  | It should throw IllegalArgumentException when the 'num' is greater than 50   |
| 7  | It should throw IllegalArgumentException when the 't' is less than 1         |
| 8  | It should throw IllegalArgumentException when the 't' is greater than 50     |
