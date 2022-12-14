package com.siazon.linknode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkCrossTest {
    LinkCross test;

    @BeforeEach
    void setUp() {
        test = new LinkCross();
    }

    @Test
    void getIntersectionNode() {
        System.out.println(test.getIntersectionNode(test.a, test.b).val);
    }

    @Test
    void coinChangeTest() {
        int[] a = new int[]{1, 2, 5};
        test.coinChange(a, 11);
    }

    @Test
    void reverseTest() {
        ListNode head = test.reverse(test.a);
        System.out.println(head.val);
    }

}