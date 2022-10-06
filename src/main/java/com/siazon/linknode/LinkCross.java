package com.siazon.linknode;

import java.util.Arrays;

public class LinkCross {
    ListNode a;
    ListNode b;

    public LinkCross() {
        a = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a.next = a2;
        a2.next = a3;
        a3.next = a4;

        b = new ListNode(11);
        ListNode b2 = new ListNode(12);
        b.next = b2;
        b2.next = a3;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode node;

    public ListNode reverseToNumber(ListNode head, int n) {
        if (n == 1) {
            node = head.next;
            return head;
        }
        ListNode last = reverseToNumber(head.next, n - 1);
        head.next.next = head;
        head.next = node;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseToNumber(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
