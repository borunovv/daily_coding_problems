package com.borunovv.dailycoding.amazon.mediun;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * This problem was asked by Amazon.
 * Given a linked list and an integer k, remove the k-th node from the end of the list and return the head of the list.
 * k is guaranteed to be smaller than the length of the list.
 * Do this in one pass.
 */
public class Solver398 {

    public static void main(String[] args) {
        assertEquals("1,2,3,4,5", makeList(5).toString());

        assertEquals("1,2,3,4", deleteKFromEnd(makeList(5), 0).toString());
        assertEquals("1,2,3,5", deleteKFromEnd(makeList(5), 1).toString());
        assertEquals("1,2,4,5", deleteKFromEnd(makeList(5), 2).toString());
        assertEquals("1,3,4,5", deleteKFromEnd(makeList(5), 3).toString());
        assertEquals("2,3,4,5", deleteKFromEnd(makeList(5), 4).toString());
        assertEquals("1,2,3,4,5", deleteKFromEnd(makeList(5), 5).toString());
        assertEquals("1,2,3,4,5", deleteKFromEnd(makeList(5), 6).toString());

        assertNull(deleteKFromEnd(makeList(1), 0));
        assertEquals("1", deleteKFromEnd(makeList(1), 1).toString());

        assertEquals("1", deleteKFromEnd(makeList(2), 0).toString());
        assertEquals("2", deleteKFromEnd(makeList(2), 1).toString());

        assertNull(deleteKFromEnd(makeList(0), 0));
        assertNull(deleteKFromEnd(makeList(0), 1));
    }

    private static Node makeList(int n) {
        if (n <= 0) return null;
        Node root = new Node(1);
        Node head = root;
        for (int i = 2; i <= n; ++i) {
            head = head.append(new Node(i));
        }
        return root;
    }

    private static Node deleteKFromEnd(Node root, int k) {
        if (root == null) return null;
        
        int tailSize = 0;
        Node head = root;
        Node tail = null;
        while (head.next != null) {
            head = head.next;
            if (tailSize < k) {
                tailSize++;
            } else {
                if (tail == null) {
                    tail = root;
                } else {
                    tail = tail.next;
                }
            }
        }
        if (tailSize == k) {
            if (tail == null) {
                return root.next;
            }
            tail.next = tail.next.next;
        }
        return root;
    }


    private static class Node {
        public final int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node append(Node next) {
            this.next = next;
            return next;
        }

        @Override
        public String toString() {
            String res = String.valueOf(value);
            if (next != null) {
                res += ",";
                res += next.toString();
            }
            return res;
        }
    }
}
