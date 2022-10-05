package com.siazon.linknode;

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
}
