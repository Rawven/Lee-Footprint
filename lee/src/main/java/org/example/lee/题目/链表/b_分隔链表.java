package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;

public class b_分隔链表 {


    /**
     * partition
     * 想要省去大量判断 那就用个头指针
     *
     * @param head head
     * @param x    x
     * @return {@link ListNode}
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = null, fast = null, l = null, r = null;
        slow = l = new ListNode(0);
        fast = r = new ListNode(0);
        while (head != null) {
            if (head.val < x) {
                slow.next = head;
                slow = slow.next;
            } else {
                fast.next = head;
                fast = fast.next;

            }
            head = head.next;
        }
        fast.next = null;
        slow.next = r.next;
        return l.next;
    }
}
