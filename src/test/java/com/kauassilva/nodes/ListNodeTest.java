package com.kauassilva.nodes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    @DisplayName("Should instantiate an empty linked list")
    void instantiateEmptyLinkedList() {
        ListNode node = new ListNode();
        assertNotNull(node);
    }

    @Test
    @DisplayName("Should create a linked list with one node when the input array has one element")
    void createLinkedListWithOneNode() {
        int[] values = {1};
        ListNode expected = new ListNode(1);

        ListNode actual = ListNode.createListNode(values);

        assertEquals(expected.val, actual.val);
        assertNull(actual.next);
    }

    @Test
    @DisplayName("Should create a linked list with multiple nodes when the input array has multiple elements")
    void createLinkedListWithMultipleNodes() {
        int[] values = {1, 2, 3, 4, 5};
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode actual = ListNode.createListNode(values);

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
    @DisplayName("Should return 'null' when the input array is null")
    void createLinkedListWithNullInput() {
        assertNull(ListNode.createListNode(null));
    }

    @Test
    @DisplayName("Should return 'null' when the input array is empty")
    void createLinkedListWithEmptyInput() {
        int[] values = {};

        assertNull(ListNode.createListNode(values));
    }

}