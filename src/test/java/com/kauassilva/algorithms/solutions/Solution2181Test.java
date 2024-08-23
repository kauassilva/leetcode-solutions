package com.kauassilva.algorithms.solutions;

import com.kauassilva.nodes.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2181Test {

    private static Solution2181 solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution2181();
    }

    @Test
    @DisplayName("It should handle the head for the example 1")
    void shouldHandleHeadForExample1() {
        int[] headListNodeValues = {0, 3, 1, 0, 4, 5, 2, 0};
        int[] expectedListNodeValues = {4, 11};
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

    @Test
    @DisplayName("It should handle the head for the example 2")
    void shouldHandleHeadForExample2() {
        int[] headListNodeValues = {0, 1, 0, 3, 0, 2, 2, 0};
        int[] expectedListNodeValues = {1, 3, 4};
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

    @Test
    @DisplayName("It should handle a linked list with a single non-zero node between two zeros")
    void shouldHandleSingleNonZeroNodeBetweenZeros() {
        int[] headListNodeValues = {0, 3, 0};
        int[] expectedListNodeValues = {3};
        ListNode head = ListNode.createListNode(headListNodeValues);
        ListNode expected = ListNode.createListNode(expectedListNodeValues);

        ListNode actual = solution.mergeNodes(head);

        assertEquals(expected.getVal(), actual.getVal());
        assertNull(actual.getNext());
    }

    @Test
    @DisplayName("It should handle a linked list with the maximum node length allowed")
    void shouldHandleMaximumNodeLengthAllowed() {
        int[] headListNodeValues = new int[200000];
        headListNodeValues[0] = 0;
        headListNodeValues[1] = 1;

        for (int i = 2; i < headListNodeValues.length; i++) {
            headListNodeValues[i] = (i & 1) == 0 ? 1 : 0;
        }

        ListNode head = ListNode.createListNode(headListNodeValues);

        int[] expectedListNodeValues = new int[99999];

        for (int i = 0; i < expectedListNodeValues.length; i++) {
            expectedListNodeValues[i] = i != 0 ? 1 : 2;
        }

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

    @Test
    @DisplayName("It should handle a linked list with the maximum node value allowed")
    void shouldHandleNodeValue1000() {
        int[] headListNodeValues = {0, 1000, 0};
        int[] expectedListNodeValues = {1000};
        ListNode head = ListNode.createListNode(headListNodeValues);
        ListNode expected = ListNode.createListNode(expectedListNodeValues);

        ListNode actual = solution.mergeNodes(head);

        assertEquals(expected.getVal(), actual.getVal());
        assertNull(actual.getNext());
    }

    @Test
    @DisplayName("It should handle a linked list with a node length less than allowed")
    void shouldHandleNodeLengthLessThanAllowed() {
        int[] headListNodeValues = {0, 0};
        ListNode head = ListNode.createListNode(headListNodeValues);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.mergeNodes(head));

        String expectedMessage = "expected 'head' to have 3 <= size <= 200000 but got 2";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should handle a linked list with a node length greater than allowed")
    void shouldHandleNodeLengthGreaterThanAllowed() {
        int[] headListNodeValues = new int[200001];

        for (int i = 0; i < headListNodeValues.length; i++) {
            headListNodeValues[i] = (i & 1) == 0 ? 0 : 1;
        }

        ListNode head = ListNode.createListNode(headListNodeValues);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.mergeNodes(head));

        String expectedMessage = "expected 'head' to have 3 <= size <= 200000 but got 200001";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should handle a linked list with a node value less than the minimum node value allowed")
    void shouldHandleNodeValueLessThanAllowed() {
        int[] headListNodeValues = {0, -1, 0};
        ListNode head = ListNode.createListNode(headListNodeValues);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.mergeNodes(head));

        String expectedMessage = "'head' must consist of values from 0 to 1000 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should handle a linked list with a node value greater than the minimum node value allowed")
    void shouldHandleNodeValueGreaterThanAllowed() {
        int[] headListNodeValues = {0, 1001, 0};
        ListNode head = ListNode.createListNode(headListNodeValues);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.mergeNodes(head));

        String expectedMessage = "'head' must consist of values from 0 to 1000 only";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should handle a linked list with consecutive zeros")
    void shouldHandleConsecutiveZeros() {
        int[] headListNodeValues = {0, 3, 1, 0, 0, 4, 5, 2, 0};
        ListNode head = ListNode.createListNode(headListNodeValues);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.mergeNodes(head));

        String expectedMessage = "No consecutive 0s";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should handle a linked list with a non-zero node at the beginning")
    void shouldHandleNonZeroNodeAtBeginning() {
        int[] headListNodeValues = {3, 1, 0};
        ListNode head = ListNode.createListNode(headListNodeValues);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.mergeNodes(head));

        String expectedMessage = "First node should be 0";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("It should handle a linked list with a non-zero node at the end")
    void shouldHandleNonZeroNodeAtEnd() {
        int[] headListNodeValues = {0, 3, 1};
        ListNode head = ListNode.createListNode(headListNodeValues);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> solution.mergeNodes(head));

        String expectedMessage = "Last node should be 0";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}