package com.kauassilva.project.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerSolutionTest {

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