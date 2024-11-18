package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;

public class a_反转链表 {
	public ListNode reverseList(ListNode head) {
		ListNode h1 = null, h2 = null, h3 = null;
		while (head != null) {
			h1 = head.next;
			head.next = h2;
			h2 = head;
			head = h1;
		}
		return h2;
	}
}
