package com.kauassilva.algorithms.solutions;

public class Solution2769 {

    public static int theMaximumAchievableX(int num, int t) {
        validateTheMaximumAchievableX(num, t);
        int maximumAchievable = num;

        for (int i=0; i<t; i++) {
            maximumAchievable+=2;
        }

        return maximumAchievable;
    }

    private static void validateTheMaximumAchievableX(int num, int t) {
        validateNumValue(num, "expected 'num' to have value from 1 to 50 only");
        validateNumValue(t, "expected 't' to have value from 1 to 50 only");
    }

    private static void validateNumValue(int num, String s) {
        if (num < 1 || num > 50) {
            throw new IllegalArgumentException(s);
        }
    }

}
