package com.kauassilva.algorithms.solutions;

import com.kauassilva.nodes.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Solution2181Test {

    private static Solution2181 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution2181();
    }

    @DisplayName("It should return the head correctly for")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForCorrectReturns")
    void shouldReturnHeadCorrectly(int[] headListNodeValues, int[] expectedListNodeValues) {
        ListNode head = ListNode.createListNode(headListNodeValues);
        ListNode expected = ListNode.createListNode(expectedListNodeValues);
        ListNode actual = solution.mergeNodes(head);

        while (expected.getNext() != null) {
            assertEquals(expected.getVal(), actual.getVal());
            expected = expected.getNext();
            actual = actual.getNext();

            if (expected.getNext() == null) {
                assertNull(actual.getNext());
            }
        }
    }

    public static Stream<Arguments> testDataForCorrectReturns() {
        int[] headMaximumValues = new int[200000];
        int[] expectedMaximumValues = new int[99999];

        headMaximumValues[0] = 0;
        headMaximumValues[1] = 1;
        for (int i = 2; i < headMaximumValues.length; i++) {
            headMaximumValues[i] = (i & 1) == 0 ? 1 : 0;
        }

        for (int i = 0; i < expectedMaximumValues.length; i++) {
            expectedMaximumValues[i] = i != 0 ? 1 : 2;
        }

        return Stream.of(
                arguments(named("the LeetCode example 1", new int[] {0, 3, 1, 0, 4, 5, 2, 0}),
                        new int[] {4, 11}),
                arguments(named("the LeetCode example 2", new int[] {0, 1, 0, 3, 0, 2, 2, 0}),
                        new int[] {1, 3, 4}),
                arguments(named("a linked list with a single non-zero node between two zeros", new int[] {0, 3, 0}),
                        new int[] {3}),
                arguments(named("a linked list with the maximum node length allowed", headMaximumValues),
                        expectedMaximumValues),
                arguments(named("a linked list with the maximum node value allowed", new int[] {0, 1000, 0}),
                        new int[] {1000})
        );
    }

    @DisplayName("It should throw IllegalArgumentException when")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testDataForExceptions")
    void shouldThrowException(int[] headListNodeValues, String expectedMessage) {
        ListNode head = ListNode.createListNode(headListNodeValues);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.mergeNodes(head));

        assertEquals(expectedMessage, exception.getMessage());
    }

    public static Stream<Arguments> testDataForExceptions() {
        int[] headGreaterValues = new int[200001];

        for (int i = 0; i < headGreaterValues.length; i++) {
            headGreaterValues[i] = (i & 1) == 0 ? 0 : 1;
        }

        return Stream.of(
                arguments(named("a linked list with a node length is less than allowed", new int[] {0, 0}),
                        "expected 'head' to have 3 <= size <= 200000 but got 2"),
                arguments(named("a linked list with a node length is greater than allowed", headGreaterValues),
                        "expected 'head' to have 3 <= size <= 200000 but got 200001"),
                arguments(named("a linked list with a node value is less than the minimum node value allowed", new int[] {0, -1, 0}),
                        "'head' must consist of values from 0 to 1000 only"),
                arguments(named("a linked list with a node value is greater than the minimum node value allowed", new int[] {0, 1001, 0}),
                        "'head' must consist of values from 0 to 1000 only"),
                arguments(named("a linked list has consecutive zeros", new int[] {0, 3, 1, 0, 0, 4, 5, 2, 0}),
                        "No consecutive 0s"),
                arguments(named("a linked list has a non-zero node at the beginning", new int[] {3, 1, 0}),
                        "First node should be 0"),
                arguments(named("a linked list has a non-zero node at the end", new int[] {0, 3, 1}),
                        "Last node should be 0")
        );
    }

}