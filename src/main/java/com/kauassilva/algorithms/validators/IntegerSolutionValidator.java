package com.kauassilva.algorithms.validators;

public class IntegerSolutionValidator {

    /**
     * <strong>Constraints:</strong>
     * <ul>
     *   <li>{@code 2 <= s.length <= 100}</li>
     *   <li>{@code s} consists only of lowercase English letters.</li>
     * </ul>
     *
     * @param s a String
     * @see <a href="https://leetcode.com/problems/score-of-a-string/">3110.
     * Score of a String</a>
     */
    public static void validateScoreOfString(String s) {
        if (s.length() < 2 || s.length() > 100) {
            throw new IllegalArgumentException("Expected 's' to have 2 <= size >= 100 but got " + s.length() + ".");
        }
        if (!s.matches("[a-z]+")) {
            throw new IllegalArgumentException("'s' must consist of values from a to z only");
        }
    }

}
