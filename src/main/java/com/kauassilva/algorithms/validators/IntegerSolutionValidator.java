package com.kauassilva.algorithms.validators;

public class IntegerSolutionValidator {

    /**
     * <strong>Constraints:</strong>
     * <ul>
     *     <li>{@code 1 <= num, t <= 50}</li>
     * </ul>
     *
     * @param num an integer
     * @param t an integer
     * @see <a href="https://leetcode.com/problems/find-the-maximum-achievable-number/description/">
     *      2769. Find the Maximum Achievable Number</a>
     */
    public static void validateTheMaximumAchievableX(int num, int t) {
        if (num < 1 || num > 50) {
            throw new IllegalArgumentException("expected 'num' to have value from 1 to 50 only");
        }
        if (t < 1 || t > 50) {
            throw new IllegalArgumentException("expected 't' to have value from 1 to 50 only");
        }
    }

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
