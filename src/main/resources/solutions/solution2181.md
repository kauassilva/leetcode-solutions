# 2181. Merge Nodes in Between Zeros

You are given the `head` of a linked list, which contains a series of integers **separated** by `0`'s. The **beginning** and **end** of the linked list will have `Node.val == 0`.

For **every** two consecutive `0`'s, **merge** all the nodes lying in between them into a single node whose value is the **sum** of all the merged nodes. The modified list should not contain any `0`'s.

Return *the* `head` *of the modified linked list*.

**Constraints:**
- The number of nodes in the list is in the range `[3, 2 * 10^5]`.
- `0 <= Node.val <= 1000`
- There are **no** two consecutive nodes with `Node.val == 0`.
- The **beginning** and **end** of the linked list have `Node.val == 0`.


[Link to the LeetCode](https://leetcode.com/problems/merge-nodes-in-between-zeros/description/)


## My Solution

for my project, I've chosen to encapsulate the attributes of the `ListNode` class and use getters and setters to manipulate those attributes. Therefore, if you'd like to base your solution on mine, follow the approach outlined in the code comments.

For further details, see [Public or private attributes for Node classes?](../notes/notes.md)

````java
public ListNode mergeNodes(ListNode head) {
    validateMergeNodes(head);
    ListNode result = new ListNode(0);
    ListNode current = result;
    ListNode iterator = head.getNext(); // head.next
    int sum = 0;

    while (iterator != null) {
        if (iterator.getVal() == 0) { // iterator.val
            current.setNext(new ListNode(sum)); // current.next = new ListNode(sum)
            current = current.getNext(); // current.next
            sum = 0;
        } else {
            sum += iterator.getVal(); // iterator.val
        }

        iterator = iterator.getNext(); // iterator.next
    }

    return result.getNext(); // result.next
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution2181.java)



## Method Validation

````java
private void validateMergeNodes(ListNode head) {
    validateHeadLength(head);
    validateNodeValues(head);
    validateConsecutiveZeros(head);
    validateFirstNode(head);
    validateLastNode(head);
}

private void validateHeadLength(ListNode head) {
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

private void validateNodeValues(ListNode head) {
    ListNode current = head;

    while (current != null) {
        if (current.getVal() < 0 || current.getVal() > 1000) { // current.val
            throw new IllegalArgumentException("'head' must consist of values from 0 to 1000 only");
        }

        current = current.getNext(); // current.next
    }
}

private void validateConsecutiveZeros(ListNode head) {
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

private void validateFirstNode(ListNode head) {
    if (head.getVal() != 0) { // head.val
        throw new IllegalArgumentException("First node should be 0");
    }
}

private void validateLastNode(ListNode head) {
    ListNode last = head;
    while (last != null) {
        if (last.getNext() == null && last.getVal() != 0) { // last.next && last.val
            throw new IllegalArgumentException("Last node should be 0");
        }
        last = last.getNext(); // last.next
    }
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution2181.java)



### Tests

How to run the tests:

````bash
mvn test -Dtest=Solution2181Test
````

#### Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/Solution2181Test.java))

- **It should return the head correctly for**
  - 1 : the LeetCode example 1
  - 2 : the LeetCode example 2
  - 3 : a linked list with a single non-zero node between two zeros
  - 4 : a linked list with the maximum node length allowed
  - 5 : a linked list with the maximum node value allowed


- **It should throw IllegalArgumentException when**
  - 1 : a linked list with a node length is less than allowed
  - 2 : a linked list with a node length is greater than allowed
  - 3 : a linked list with a node value is less than the minimum node value allowed
  - 4 : a linked list with a node value is greater than the minimum node value allowed
  - 5 : a linked list has consecutive zeros
  - 6 : a linked list has a non-zero node at the beginning
  - 7 : a linked list has a non-zero node at the end
