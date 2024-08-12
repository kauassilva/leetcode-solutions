package com.kauassilva.algorithms.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 * There is a programming language with only <b>four</b> operations and <b>one
 * </b> variable {@code X}:
 * <ul>
 *     <li>{@code ++X} and {@code X++} <b>increments</b> the value of the
 *     variable {@code X} by {@code 1}.</li>
 *     <li>{@code --X} and {@code X--} <b>decrements</b> the value of the
 *     variable {@code X} by {@code 1}.</li>
 * </ul>
 *
 * <p>
 * Initially, the value of {@code X} is {@code 0}.
 *
 * <p>
 * Given an array of strings {@code operations} containing a list of
 * operations, return <i>the <b>final</b> value of</i> {@code X} <i>after
 * performing all the operations</i>.
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code 1 <= operations.length <= 100}</li>
 *     <li>{@code operations[i]} will be either {@code "++X"}, {@code "X++"},
 *     {@code "--X"}, or {@code "X--"}</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/">
 *     2011. Final Value of Variable After Performing Operations</a>
 */
class Solution2011Test {

    @Test
    @DisplayName("It should return the correct value for the example 1")
    void shouldReturnTheCorrectValueForExample1() {
        String[] operations = {"--X", "X++", "X++"};
        int expected = 1;

        int actual = Solution2011.finalValueAfterOperations(operations);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the correct value for the example 2")
    void shouldReturnTheCorrectValueForExample2() {
        String[] operations = {"++X", "++X", "X++"};
        int expected = 3;

        int actual = Solution2011.finalValueAfterOperations(operations);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the correct value for the example 3")
    void shouldReturnTheCorrectValueForExample3() {
        String[] operations = {"X++", "++X", "--X", "X--"};
        int expected = 0;

        int actual = Solution2011.finalValueAfterOperations(operations);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the correct value when the operations array contains only one operation")
    void shouldReturnTheCorrectValueWhenOperationsArrayContainsOnlyOneOperation() {
        String[] operations = {"++X"};
        int expected = 1;

        int actual = Solution2011.finalValueAfterOperations(operations);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("It should return the correct value when the operations array contains the maximum length allowed (100)")
    void shouldReturnTheCorrectValueWhenOperationsArrayContainsMaximumLength() {
        String operation = "X++";
        String[] operations = new String[100];
        int expected = 100;

        Arrays.fill(operations, operation);

        int actual = Solution2011.finalValueAfterOperations(operations);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when there are no operations")
    void shouldThrowExceptionWhenInputThereAreNoOperations() {
        String[] operations = new String[0];

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution2011.finalValueAfterOperations(operations));

        String expectedMessage = "expected 'operations' to have 1 <= size <= 100 but got " + operations.length;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the input length is above the maximum")
    void shouldThrowExceptionWhenInputLengthIsAboveMaximum() {
        String operation = "X++";
        String[] operations = new String[101];

        Arrays.fill(operations, operation);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution2011.finalValueAfterOperations(operations));

        String expectedMessage = "expected 'operations' to have 1 <= size <= 100 but got " + operations.length;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should throw an IllegalArgumentException when the input value is different than allowed")
    void shouldThrowExceptionWhenInputValueIsDifferentThanAllowed() {
        String[] operations = {"+X", "x+", "-x", "x-", "az"};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution2011.finalValueAfterOperations(operations));

        String expectedMessage = "'operations' must consist of values in ['X++', 'X--', '++X', '--X'] only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}