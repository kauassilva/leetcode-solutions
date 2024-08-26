package com.kauassilva.nodes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ListNodeTest {

    @Test
    @DisplayName("Should instantiate an empty linked list")
    void instantiateEmptyLinkedList() {
        ListNode node = new ListNode();
        assertNotNull(node);
    }

    @Test
    @DisplayName("Should set the 'val' correctly")
    void shouldSetValCorrectly() {
        ListNode node = new ListNode();
        node.setVal(18);

        assertEquals(18, node.getVal());
    }

    @Test
    @DisplayName("Should set the 'next' correctly")
    void shouldSetNextCorrectly() {
        ListNode node = new ListNode(18);
        ListNode nextNode = new ListNode(12);
        node.setNext(nextNode);

        assertEquals(nextNode, node.getNext());
    }

    @DisplayName("Should create a linked list correctly for")
    @ParameterizedTest(name = "{index} : {0}")
    @MethodSource("testData")
    void createLinkedListCorrectly(int[] values, ListNode expected) {
        ListNode actual = ListNode.createListNode(values);

        while (expected.getNext() != null) {
            assertEquals(expected.getVal(), actual.getVal());
            expected = expected.getNext();
            actual = actual.getNext();

            if (expected.getNext() == null) {
                assertNull(actual.getNext());
            }
        }
    }

    @DisplayName("Should return 'null' when the input array is null or empty")
    @ParameterizedTest(name = "{index} : {0}")
    @NullAndEmptySource
    void createLinkedListWithNullAndEmptyInput(int[] values) {
        assertNull(ListNode.createListNode(values));
    }

    public static Stream<Arguments> testData() {
        return Stream.of(
                arguments(named("single node", new int[] {1}), new ListNode(1)),
                arguments(named("multi node", new int[] {1, 2, 3, 4, 5}), new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))))
        );
    }

}