# My LeetCode Solutions

Welcome to my LeetCode Solutions repository. In this repository, I share my Java solutions for various LeetCode problems. Each solution is thoroughly tested, and I've included custom validation methods to handle problem-specific constraints.

If you want to see the list of solved problems, click here: [Solved Problems](src/main/java/com/kauassilva/algorithms/algorithms.md)



## Problems

### Description
For each problem, I provided the same description as the original problem (excluding the images), and a link to the original LeetCode problem. Besides that, all problems have a method to validate the constraints imposed in the problem description Here's an example:
````java
/**
 * <p>
 * You are given a string {@code s}. The <b>score</b> of a string is
 * defined as the sum of the absolute difference between the <b>ASCII</b>
 * values of adjacent characters.
 *
 * <p>
 * Return the <b>score</b>.
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code 2 <= s.length <= 100}</li>
 *     <li>{@code s} consists only of lowercase English letters.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/score-of-a-string/">3110.
 * Score of a String</a>
 */
public class ScoreOfString {

   public static int scoreOfString(String s) {
      validateScoreOfString(s);
      int score = 0;

      for (int i=0; i<s.length()-1; i++) {
         score += Math.abs(s.charAt(i) - s.charAt(i+1));
      }

      return score;
   }
   
   private static void validateScoreOfString(String s) {
      if (s.length() < 2 || s.length() > 100) {
         throw new IllegalArgumentException("Expected 's' to have 2 <= size >= 100 but got " + s.length() + ".");
      }
      if (!s.matches("[a-z]+")) {
         throw new IllegalArgumentException("'s' must consist of values from a to z only");
      }
   }

}
````



### Tests
I've included tests for each problem, as well as additional tests that I believe are relevant to the context and specific constraints. Por exemplo:
````java
@Test
@DisplayName("It should return the score of the string 'hello'")
void shouldReturnScoreForHelloString() {
    String s = "hello";

    int output = IntegerSolution.scoreOfString(s);
    int expected = 13;

    assertEquals(expected, output);
}
````
````java
@Test
@DisplayName("It should throw an IllegalArgumentException when the length of the string is less than 2 characters")
void shouldThrowExceptionForShortString() {
    String s = "x";

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> IntegerSolution.scoreOfString(s));

    String expectedMessage = "Expected 's' to have 2 <= size >= 100 but got " + s.length() + ".";
    String actualMessage = exception.getMessage();

    assertEquals(expectedMessage, actualMessage);
}
````



## Getting Started

1. Clone the repository:
    ````bash
    git clone git@github.com:kauassilva/leetcode-solutions.git
    ````
2. Running Tests:
    ````bash
    mvn test
    ````
