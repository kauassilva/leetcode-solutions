package com.kauassilva.algorithms.solutions;

public class Solution3110 {

    public static int scoreOfString(String s) {
        validateScoreOfString(s);
        int score = 0;

        for (int i=0; i<s.length()-1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i+1));
        }

        return score;
    }

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

}
