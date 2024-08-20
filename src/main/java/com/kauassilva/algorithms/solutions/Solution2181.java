package com.kauassilva.algorithms.solutions;

import com.kauassilva.nodes.ListNode;

public class Solution2181 {

    public static ListNode mergeNodes(ListNode head) {
        validateMergeNodes(head);
        ListNode result = new ListNode(0);
        ListNode current = result;
        ListNode iterator = head.getNext();
        int sum = 0;

        while (iterator != null) {
            if (iterator.getVal() == 0) {
                current.setNext(new ListNode(sum));
                current = current.getNext();
                sum = 0;
            } else {
                sum += iterator.getVal();
            }

            iterator = iterator.getNext();
        }

        return result.getNext();
    }

    private static void validateMergeNodes(ListNode head) {
        validateHeadLength(head);
        validateNodeValues(head);
        validateConsecutiveZeros(head);
        validateFirstNode(head);
        validateLastNode(head);
    }

    private static void validateHeadLength(ListNode head) {
        int count = 0;
        ListNode current = head;

        while (current != null) {
            current = current.getNext(); // current.next
            count++;
        }

        if (count < 3 || count > 200000) {
            throw new IllegalArgumentException("expected 'head' to have 3 <= size <= 200000 but got " + count);
        }
    }

    private static void validateNodeValues(ListNode head) {
        ListNode current = head;

        while (current != null) {
            if (current.getVal() < 0 || current.getVal() > 1000) { // current.val
                throw new IllegalArgumentException("'head' must consist of values from 0 to 1000 only");
            }

            current = current.getNext(); // current.next
        }
    }

    private static void validateConsecutiveZeros(ListNode head) {
        int count = 0;
        ListNode current = head;

        while (current != null) {
            if (current.getVal() == 0) { // current.val
                count++;

                if (count == 2) {
                    throw new IllegalArgumentException("No consecutive 0s");
                }
            } else {
                count = 0;
            }

            current = current.getNext(); // current.next
        }
    }

    private static void validateFirstNode(ListNode head) {
        if (head.getVal() != 0) { // head.val
            throw new IllegalArgumentException("First node should be 0");
        }
    }

    private static void validateLastNode(ListNode head) {
        ListNode last = head;
        while (last != null) {
            if (last.getNext() == null && last.getVal() != 0) { // last.next && last.val
                throw new IllegalArgumentException("Last node should be 0");
            }
            last = last.getNext(); // last.next
        }
    }

}
