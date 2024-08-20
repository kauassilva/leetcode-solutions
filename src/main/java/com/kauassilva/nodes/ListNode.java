package com.kauassilva.nodes;

public class ListNode {

    private int val;
    private ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * This function creates a new linked list from an array of integers.
     *
     * @param listNodeValues An array of integers representing the values of
     *                       the linked list nodes.
     * @return The {@code head} of the newly created linked list. If the input
     * array is null or empty, the function returns {@code null}.
     */
    public static ListNode createListNode(int[] listNodeValues) {
        if (listNodeValues == null || listNodeValues.length == 0) {
            return null;
        }

        ListNode head = new ListNode(listNodeValues[0]);
        ListNode current = head;

        for (int i = 1; i < listNodeValues.length; i++) {
            current.next = new ListNode(listNodeValues[i]);
            current = current.next;
        }

        return head;
    }

}
