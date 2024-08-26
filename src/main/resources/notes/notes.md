# Some notes

This file contains some notes about snippets or anything related, for my own
reference. It serves as a way for me to revisit decisions or reflect on various
topics.

However, these notes might also be interesting for anyone. And I welcome
corrections when my thinking is incorrect. If you notice errors or areas where
I can improve, please point them out and explain why my approach is
incorrect...


## Topics covered

1. Public or private attributes for Node classes?
2. Why am I using `@ParameterizedTest` instead of `@Test`
3. Why I used `Logger` instead of `System.out`


### 1 - Public or private attributes for Node classes?

Public attributes themselves violate the principle of encapsulation. So, should
I change them? However, my solutions are based on **LeetCode** problems. And
the problems that require `ListNode` or `TreeNode` often have attributes with
_default_ scope, and this affects how I write solution methods.

In LeetCode, there's no `getVal()`, for example. If you want to access the
value, simply use the attribute directly. However, I don't like this approach.
It's acceptable in the LeetCode environment, but here, I thought it would be
interesting to adapt. Of course, within the code and in the corresponding `.md`
file, I'll indicate the appropriate LeetCode approach and reference this note
in case anyone wonders why it's different.

Without adaptation:

````java
public class ListNode {

    public int val;
    public ListNode next;
    
    //...
}

public class Solution2181 {

    public static ListNode mergeNodes(ListNode head) {
        //...
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
        //...
    }
}
````

With adaptation:

````java
public class ListNode {

    private int val;
    private ListNode next;
    
    //...

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
    
    //...
}

public class Solution2181 {

    public static ListNode mergeNodes(ListNode head) {
        //...
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
        //...
    }
}
````


### 2 - Why am I using `@ParameterizedTest` instead of `@Test`

Parameterized tests allow a test to run multiple times with different
arguments. This is useful for testing code behaviour under various conditions.

The use of `@ParameterizedTest` avoids code duplication. It also enhances code
maintainability and readability by separating the test logic from the data.


### 3 - Why I used `Logger` instead of `System.out`

`System.out` is sufficient for simple applications. On the other hand, `Logger`
is more suitable for complex applications, specially in production
environments. `Logger` can be configured asynchronously, which doesn't
significantly impact performance in systems with high log volumes. In contrast,
`System.out`, being a synchronous method, can lead to lower system performance.

I haven't found a critical need for `Logger` in my project (though that doesn't
mean there isn't one). However, I used it in the `main()` method just to try 
something different.

Application with `System.out`:

````java
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello Leetcode Solutions!");
    }

}
````

Application with `Logger`:

````java
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Hello Leetcode Solutions!");
    }

}
````
