package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerSolutionTest {

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
    @Nested
    class theMaximumAchievableX {
        @Test
        @DisplayName("It should return the maximum achievable number for 'num=4' and 't=1'")
        void shouldReturnTheMaximumAchievableNumberForExample1() {
            int num = 4;
            int t = 1;

            assertEquals(6, IntegerSolution.theMaximumAchievableX(num, t));
        }

        @Test
        @DisplayName("It should return the maximum achievable number for 'num=3' and 't=2'")
        void shouldReturnTheMaximumAchievableNumberForExample2() {
            int num = 3;
            int t = 2;

            assertEquals(7, IntegerSolution.theMaximumAchievableX(num, t));
        }

        @Test
        @DisplayName("It should return the maximum achievable number to the minimum allowed values")
        void shouldReturnTheMaximumAchievableNumberToTheMinimumAllowed() {
            int num = 1;
            int t = 1;

            assertEquals(3, IntegerSolution.theMaximumAchievableX(num, t));
        }

        @Test
        @DisplayName("It should return the maximum achievable number to the maximum allowed values")
        void shouldReturnTheMaximumAchievableNumberToTheMaximumAllowed() {
            int num = 50;
            int t = 50;

            assertEquals(150, IntegerSolution.theMaximumAchievableX(num, t));
        }

        @Test
        @DisplayName("It should throw IllegalArgumentException when the 'num' is less than 1")
        void shouldThrowExceptionForNumLessThan1() {
            int num = 0;
            int t = 1;

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> IntegerSolution.theMaximumAchievableX(num, t));

            String expectedMessage = "expected 'num' to have value from 1 to 50 only";
            String actualMessage = exception.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }

        @Test
        @DisplayName("It should throw IllegalArgumentException when the 'num' is greater than 50")
        void shouldThrowExceptionForNumGreaterThan50() {
            int num = 51;
            int t = 1;

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> IntegerSolution.theMaximumAchievableX(num, t));

            String expectedMessage = "expected 'num' to have value from 1 to 50 only";
            String actualMessage = exception.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }

        @Test
        @DisplayName("It should throw IllegalArgumentException when the 't' is less than 1")
        void shouldThrowExceptionForTLessThan1() {
            int num = 1;
            int t = 0;

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> IntegerSolution.theMaximumAchievableX(num, t));

            String expectedMessage = "expected 't' to have value from 1 to 50 only";
            String actualMessage = exception.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }

        @Test
        @DisplayName("It should throw IllegalArgumentException when the 't' is greater than 50")
        void shouldThrowExceptionForTGreaterThan50() {
            int num = 1;
            int t = 51;

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> IntegerSolution.theMaximumAchievableX(num, t));

            String expectedMessage = "expected 't' to have value from 1 to 50 only";
            String actualMessage = exception.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }

    }

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
    @Nested
    class scoreOfString {
        @Test
        @DisplayName("It should return the score of the string 'hello'")
        void shouldReturnScoreForHelloString() {
            String s = "hello";

            int output = IntegerSolution.scoreOfString(s);
            int expected = 13;

            assertEquals(expected, output);
        }

        @Test
        @DisplayName("It should return the score of the string 'zaz'")
        void shouldReturnScoreForZazString() {
            String s = "zaz";

            int output = IntegerSolution.scoreOfString(s);
            int expected = 50;

            assertEquals(expected, output);
        }

        @Test
        @DisplayName("It should return the score of the string with 2 characters")
        void shouldReturnScoreForShortString() {
            String s = "jx";

            int output = IntegerSolution.scoreOfString(s);
            int expected = 14;

            assertEquals(expected, output);
        }

        @Test
        @DisplayName("It should return the score of the string with 100 characters")
        void shouldReturnScoreForLongString() {
            String s = "bqjxwzvqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyf" +
                    "jgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqy";

            int output = IntegerSolution.scoreOfString(s);
            int expected = 811;

            assertEquals(expected, output);
        }

        @Test
        @DisplayName("It should throw an IllegalArgumentException when the length of the string is less than 2 characters")
        void shouldThrowExceptionForShortString() {
            String s = "x";

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> IntegerSolution.scoreOfString(s));

            String expectedMessage = "Expected 's' to have 2 <= size >= 100 but got " + s.length() + ".";
            String actualMessage = exception.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }

        @Test
        @DisplayName("It should throw IllegalArgumentException when the length of the string is greater than 100 characters")
        void shouldThrowExceptionForLongString() {
            String s = "bqjxwzvqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyf" +
                    "jgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyr";

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> IntegerSolution.scoreOfString(s));

            String expectedMessage = "Expected 's' to have 2 <= size >= 100 but got " + s.length() + ".";
            String actualMessage = exception.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }
        @Test
        @DisplayName("It should throw an IllegalArgumentException when the string contains an uppercase character")
        void shouldThrowExceptionForUppercaseCharacters() {
            String s = "azA";

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> IntegerSolution.scoreOfString(s));

            String expectedMessage = "'s' must consist of values from a to z only";
            String actualMessage = exception.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }
    }

}