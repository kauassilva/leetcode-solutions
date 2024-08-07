package com.kauassilva.algorithms.solutions;

/**
 * <p>
 * Given two integers, {@code num} and {@code t}. A <b>number is
 * achievable</b> if it can become equal to {@code num} after applying the
 * following operation:
 *
 * <ul>
 *     <li>Increase or decrease the number by 1, and simultaneously
 *     increase or decrease num by 1.</li>
 * </ul>
 *
 * <p>
 * Return the <b>maximum achievable number</b> after applying the operation
 * at most {@code t} times.
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code 1 <= num, t <= 50}</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/find-the-maximum-achievable-number/description/">
 *     2769. Find the Maximum Achievable Number</a>
 */
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
        if (num < 1 || num > 50) {
            throw new IllegalArgumentException("expected 'num' to have value from 1 to 50 only");
        }
        if (t < 1 || t > 50) {
            throw new IllegalArgumentException("expected 't' to have value from 1 to 50 only");
        }
    }

}
