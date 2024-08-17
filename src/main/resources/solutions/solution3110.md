# 3110. Score of a String

You are given a string `s`. The **score** of a string is defined as the sum of the absolute difference between the **ASCII** values of adjacent characters.

Return the **score**.



**Constraints:**
- `2 <= s.length <= 100`
- `s` consists only of lowercase English letters.


[Link to the LeetCode](https://leetcode.com/problems/score-of-a-string/)

## My Solution

````java
public static int scoreOfString(String s) {
    validateScoreOfString(s);
    int score = 0;

    for (int i=0; i<s.length()-1; i++) {
        score += Math.abs(s.charAt(i) - s.charAt(i+1));
    }

    return score;
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution3110.java)



## Method Validation

````java
private static void validateScoreOfString(String s) {
    validateInputLength(s);
    validateInputCharacters(s);
}

private static void validateInputLength(String s) {
    if (s.length() < 2 || s.length() > 100) {
        throw new IllegalArgumentException("Expected 's' to have 2 <= size >= 100 but got " + s.length() + ".");
    }
}

private static void validateInputCharacters(String s) {
    if (!s.matches("[a-z]+")) {
        throw new IllegalArgumentException("'s' must consist of values from a to z only");
    }
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution3110.java)



### Tests

How to run the tests:

````bash
mvn test -Dtest=Solution3110Test
````

Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/Solution3110Test.java))

| Nº | Description                                                                                           |
|----|-------------------------------------------------------------------------------------------------------|
| 1  | It should return the score of the string 'hello'                                                      |
| 2  | It should return the score of the string 'zaz'                                                        |
| 3  | It should return the score of the string with 2 characters                                            |
| 4  | It should return the score of the string with 100 characters                                          |
| 5  | It should throw an IllegalArgumentException when the length of the string is less than 2 characters   |
| 6  | It should throw IllegalArgumentException when the length of the string is greater than 100 characters |
| 7  | It should throw an IllegalArgumentException when the string contains an uppercase character           |
