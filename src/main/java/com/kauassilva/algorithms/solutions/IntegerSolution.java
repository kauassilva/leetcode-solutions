package com.kauassilva.algorithms.solutions;

import static com.kauassilva.algorithms.validators.IntegerSolutionValidator.validateScoreOfString;
import static com.kauassilva.algorithms.validators.IntegerSolutionValidator.validateTheMaximumAchievableX;

public class IntegerSolution {

    /**
     * <p>
     * A <b>number is achievable</b> if it can become equal to {@code num}
     * after applying the following operation:
     *
     * <ul>
     *     <li>Increase or decrease the number by 1, and simultaneously
     *     increase or decrease num by 1.</li>
     * </ul>
     *
     * <p>
     * <b>Constraints:</b>
     * <ul>
     *     <li>{@code 1 <= num, t <= 50}</li>
     * </ul>
     *
     * @param num an integer
     * @param t an integer
     * @return the maximum achievable number after applying the operation at
     * most {@code t} times
     * @see <a href="https://leetcode.com/problems/find-the-maximum-achievable-number/description/">
     *     2769. Find the Maximum Achievable Number</a>
     */
    public static int theMaximumAchievableX(int num, int t) {
        validateTheMaximumAchievableX(num, t);
        int maximumAchievable = num;

        for (int i=0; i<t; i++) {
            maximumAchievable+=2;
        }

        return maximumAchievable;
    }

    /**
     * <p>
     * The <b>score</b> of a string is defined as the sum of the absolute
     * difference between the <b>ASCII</b> values of adjacent characters.
     *
     * <p>
     * <b>Constraints:</b>
     * <ul>
     *     <li>{@code 2 <= s.length <= 100}</li>
     *     <li>{@code s} consists only of lowercase English letters.</li>
     * </ul>
     *
     * @param s a String
     * @return the <b>score</b> of {@code s}
     * @see <a href="https://leetcode.com/problems/score-of-a-string/">
     *     3110. Score of a String</a>
     */
    public static int scoreOfString(String s) {
        validateScoreOfString(s);
        int score = 0;

        for (int i=0; i<s.length()-1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i+1));
        }

        return score;
    }

}
