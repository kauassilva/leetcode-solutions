package com.kauassilva.project.algorithms;

public class IntegerSolution {

    /**
     * The <strong>score</strong> of a string is defined as the sum of the
     * absolute difference between the <strong>ASCII</strong> values of
     * adjacent characters.
     * <p>
     * <strong>Constraints:</strong>
     * <ul>
     *     <li>{@code 2 <= s.length <= 100}</li>
     *     <li>{@code s} consists only of lowercase English letters.</li>
     * </ul>
     *
     * @param s a String
     * @return the <strong>score</strong> of {@code s}
     * @see <a href="https://leetcode.com/problems/score-of-a-string/">3110.
     * Score of a String</a>
     */
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
