package com.kauassilva.algorithms.solutions;

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
