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
public int finalValueAfterOperations(String[] operations) {
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
private void validateFinalValueAfterOperations(String[] operations) {
    validateInputLength(operations);
    validateInputValues(operations);
}

private void validateInputLength(String[] operations) {
    if (operations.length < 1 || operations.length > 100) {
        throw new IllegalArgumentException("expected 'operations' to have 1 <= size <= 100 but got " + operations.length);
    }
}

private void validateInputValues(String[] operations) {
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

#### Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/Solution2011Test.java))

- **It should return the final value of `X` correctly for**
  - 1 : "--X", "X++", "X++"
  - 2 : "++X", "++X", "X++"
  - 3 : "X++", "++X", "--X", "X--"
  - 4 : the operations array with only one operation
  - 5 : the operations array with the maximum length allowed (100)


- **It should throw IllegalArgumentException when**
  - 1 : there are no operations
  - 2 : the input length is above the maximum
  - 3 : the input value is different from allowed
