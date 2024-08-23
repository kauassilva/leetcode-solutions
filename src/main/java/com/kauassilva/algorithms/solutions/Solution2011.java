package com.kauassilva.algorithms.solutions;

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
public class Solution2011 {

    public int finalValueAfterOperations(String[] operations) {
        validateFinalValueAfterOperations(operations);

        int x = 0;

        for (String operation : operations) {
            x += (44 - operation.charAt(1));
        }

        return x;
    }

    private void validateFinalValueAfterOperations(String[] operations) {
        validateInputLength(operations);
        validateInputValues(operations);
    }

    private void validateInputLength(String[] operations) {
        if (operations.length < 1 || operations.length > 100) {
            throw new IllegalArgumentException("expected 'operations' to have 1 <= size <= 100 but got " + operations.length);
        }
    }

    private void validateInputValues(String[] operations) {
        for (String operation : operations) {
            if (!(operation.equals("X++") || operation.equals("++X") || operation.equals("X--") || operation.equals("--X"))) {
                throw new IllegalArgumentException("'operations' must consist of values in ['X++', 'X--', '++X', '--X'] only");
            }
        }
    }

}
