package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;

public class b_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode h, e = null;
        if (head == null) {
            return head;
        }
        while (head.next != null) {
            h = head.next;
            head.next = e;
            e = head;
            head = h;
        }
        head.next = e;
        return head;
    }
}
