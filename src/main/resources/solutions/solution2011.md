# 2011. Final Value of Variable After Performing Operations

There is a programming language with only **four** operations and **one** variable `X`:
- `++X` and `X++` **increments** the value of the variable `X` by `1`.
- `--X` and `X--` **decrements** the value of the variable `X` by `1`.

Initially, the value of `X` is `0`.

Given an array of strings `operations` containing a list of operations, return *the **final** value of* `X` *after performing all the operations*.

**Constraints:**
- `1 <= operations.length <= 100`
- `operations[i]` will be either `"++X"`, `"X++"`, `--X`, or `X--`


[Link to the LeetCode](https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/)

## My Solution

````java
public static int finalValueAfterOperations(String[] operations) {
    validateFinalValueAfterOperations(operations);

    int x = 0;

    for (String operation : operations) {
        x += (44 - operation.charAt(1));
    }

    return x;
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution2011.java)



## Method Validation

````java
private static void validateFinalValueAfterOperations(String[] operations) {
    validateInputLength(operations);
    validateInputValues(operations);
}

private static void validateInputLength(String[] operations) {
    if (operations.length < 1 || operations.length > 100) {
        throw new IllegalArgumentException("expected 'operations' to have 1 <= size <= 100 but got " + operations.length);
    }
}

private static void validateInputValues(String[] operations) {
    for (String operation : operations) {
        if (!(operation.equals("X++") || operation.equals("++X") || operation.equals("X--") || operation.equals("--X"))) {
            throw new IllegalArgumentException("'operations' must consist of values in ['X++', 'X--', '++X', '--X'] only");
        }
    }
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution2011.java)



### Tests

How to run the tests:

````bash
mvn test -Dtest=Solution2011Test
````

Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/SolutionTest2011.java))

| Nº | Description                                                                                            |
|----|--------------------------------------------------------------------------------------------------------|
| 1  | It should return the correct value for the example 1                                                   |
| 2  | It should return the correct value for the example 2                                                   |
| 3  | It should return the correct value for the example 3                                                   |
| 4  | It should return the correct value when the operations array contains only one operation               |
| 5  | It should return the correct value when the operations array contains the maximum length allowed (100) |
| 6  | It should throw an IllegalArgumentException when there are no operations                               |
| 7  | It should throw an IllegalArgumentException when the input length is above the maximum                 |
| 8  | It should throw an IllegalArgumentException when the input value is different than allowed             |
