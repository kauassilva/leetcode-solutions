package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
class Solution3110Test {

    @Test
    @DisplayName("It should return the score of the string 'hello'")
    void shouldReturnScoreForHelloString() {
        String s = "hello";

        int output = Solution3110.scoreOfString(s);
        int expected = 13;

        assertEquals(expected, output);
    }

    @Test
    @DisplayName("It should return the score of the string 'zaz'")
    void shouldReturnScoreForZazString() {
        String s = "zaz";

        int output = Solution3110.scoreOfString(s);
        int expected = 50;

        assertEquals(expected, output);
    }

    @Test
    @DisplayName("It should return the score of the string with 2 characters")
    void shouldReturnScoreForShortString() {
        String s = "jx";

        int output = Solution3110.scoreOfString(s);
        int expected = 14;

        assertEquals(expected, output);
    }

    @Test
    @DisplayName("It should return the score of the string with 100 characters")
    void shouldReturnScoreForLongString() {
        String s = "bqjxwzvqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyf" +
                "jgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqy";

        int output = Solution3110.scoreOfString(s);
        int expected = 811;

        assertEquals(expected, output);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the length of the string is less than 2 characters")
    void shouldThrowExceptionForShortString() {
        String s = "x";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution3110.scoreOfString(s));

        String expectedMessage = "Expected 's' to have 2 <= size >= 100 but got " + s.length() + ".";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw IllegalArgumentException when the length of the string is greater than 100 characters")
    void shouldThrowExceptionForLongString() {
        String s = "bqjxwzvqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyf" +
                "jgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyfjgkxqyr";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution3110.scoreOfString(s));

        String expectedMessage = "Expected 's' to have 2 <= size >= 100 but got " + s.length() + ".";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    @DisplayName("It should throw an IllegalArgumentException when the string contains an uppercase character")
    void shouldThrowExceptionForUppercaseCharacters() {
        String s = "azA";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Solution3110.scoreOfString(s));

        String expectedMessage = "'s' must consist of values from a to z only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}