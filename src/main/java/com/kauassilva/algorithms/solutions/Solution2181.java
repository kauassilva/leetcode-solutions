package com.kauassilva.algorithms.solutions;

import com.kauassilva.nodes.ListNode;

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
public class Solution2181 {

    public static ListNode mergeNodes(ListNode head) {
        validateMergeNodes(head);
        ListNode result = new ListNode(0);
        ListNode current = result;
        ListNode iterator = head.next;
        int sum = 0;

        while (iterator != null) {
            if (iterator.val == 0) {
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0;
            } else {
                sum += iterator.val;
            }

            iterator = iterator.next;
        }

        return result.next;
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
            current = current.next;
            count++;
        }

        if (count < 3 || count > 200000) {
            throw new IllegalArgumentException("expected 'head' to have 3 <= size <= 200000 but got " + count);
        }
    }

    private static void validateNodeValues(ListNode head) {
        ListNode current = head;

        while (current != null) {
            if (current.val < 0 || current.val > 1000) {
                throw new IllegalArgumentException("'head' must consist of values from 0 to 1000 only");
            }

            current = current.next;
        }
    }

    private static void validateConsecutiveZeros(ListNode head) {
        int count = 0;
        ListNode current = head;

        while (current != null) {
            if (current.val == 0) {
                count++;

                if (count == 2) {
                    throw new IllegalArgumentException("No consecutive 0s");
                }
            } else {
                count = 0;
            }

            current = current.next;
        }
    }

    private static void validateFirstNode(ListNode head) {
        if (head.val != 0) {
            throw new IllegalArgumentException("First node should be 0");
        }
    }

    private static void validateLastNode(ListNode head) {
        ListNode last = head;
        while (last != null) {
            if (last.next == null && last.val != 0) {
                throw new IllegalArgumentException("Last node should be 0");
            }
            last = last.next;
        }
    }

}
