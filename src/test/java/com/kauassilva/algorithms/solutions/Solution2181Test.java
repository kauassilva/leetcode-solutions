package com.kauassilva.algorithms.solutions;

import com.kauassilva.nodes.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 * You are given the {@code head} of a linked list, which contains a series of
 * integers <b>separated</b> by {@code 0}'s. The <b>beginning</b> and <b>end
 * </b> of the linked list will have {@code Node.val == 0}.
 *
 * <p>
 * For <b>every</b> two consecutive {@code 0}'s, <b>merge</b> all the nodes
 * lying in between them into a single node whose value is the <b>sum</b> of
 * all the merged nodes. The modified list should not contain any {@code 0}'s.
 *
 * <p>
 * Return <i>the</i> {@code head} <i>of the modified linked list</i>.
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>The number of nodes in the list is in the range {@code [3, 2 * 10^5]}.</li>
 *     <li>{@code 0 <= Node.val <= 1000}</li>
 *     <li>There are <b>no</b> two consecutive nodes with {@code Node.val == 0}.</li>
 *     <li>The <b>beginning</b> and <b>end</b> of the linked list have {@code Node.val == 0}.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/merge-nodes-in-between-zeros/description/">
 *     2181. Merge Nodes in Between Zeros</a>
 */
class Solution2181Test {

    @Test
    @DisplayName("It should handle the head for the example 1")
    void shouldHandleHeadForExample1() {
        int[] headListNodeValues = {0, 3, 1, 0, 4, 5, 2, 0};
        int[] expectedListNodeValues = {4, 11};
        ListNode head = ListNode.createListNode(headListNodeValues);
        ListNode expected = ListNode.createListNode(expectedListNodeValues);

        ListNode actual = Solution2181.mergeNodes(head);

        while (expected.next != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;

            if (expected.next == null) {
                assertNull(actual.next);
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

        ListNode actual = Solution2181.mergeNodes(head);

        while (expected.next != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;

            if (expected.next == null) {
                assertNull(actual.next);
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

        ListNode actual = Solution2181.mergeNodes(head);

        assertEquals(expected.val, actual.val);
        assertNull(actual.next);
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
        ListNode actual = Solution2181.mergeNodes(head);

        while (expected.next != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;

            if (expected.next == null) {
                assertNull(actual.next);
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

        ListNode actual = Solution2181.mergeNodes(head);

        assertEquals(expected.val, actual.val);
        assertNull(actual.next);
    }

    @Test
    @DisplayName("It should handle a linked list with a node length less than allowed")
    void shouldHandleNodeLengthLessThanAllowed() {
        int[] headListNodeValues = {0, 0};
        ListNode head = ListNode.createListNode(headListNodeValues);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Solution2181.mergeNodes(head));

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
                () -> Solution2181.mergeNodes(head));

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
                () -> Solution2181.mergeNodes(head));

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
                () -> Solution2181.mergeNodes(head));

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
                () -> Solution2181.mergeNodes(head));

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
                () -> Solution2181.mergeNodes(head));

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
                () -> Solution2181.mergeNodes(head));

        String expectedMessage = "Last node should be 0";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}