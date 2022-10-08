package com.siazon.linknode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeReverseTest {
    NodeReverse test;

    @BeforeEach
    void setUp() {
        test = new NodeReverse();
    }

    @Test
    void reverseToNumber() {
        ListNode head = test.reverseToNumber(test.a, 2);
        ListNode n = head;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    @Test
    void reverseBetween() {
        ListNode head = test.reverseBetween(test.a, 2, 3);
        ListNode n = head;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    @Test
    void reverseKGroupTest() {
        ListNode head = test.reverseKGroup(test.a, 2);
        ListNode n = head;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}