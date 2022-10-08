package com.siazon.linknode;

public class NodeReverse {
    ListNode a;

    public NodeReverse() {
        a = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
    }

    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
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

    public boolean isPalindrome(ListNode head) {
        node = head;
        return traverserome(head);
    }

    private boolean traverserome(ListNode head) {
        if (head == null) return true;
        boolean res = traverserome(head.next);

        res = res && node.val == head.val;
        node = node.next;
        return res;
    }

}
