package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;

public class a_移除链表元素 {

	public ListNode removeElements(ListNode head, int val) {
		ListNode node = head, help = null;
		while (node != null) {
			if (node.val == val) {
				if (help == null) {
					head = node.next;
				} else {
					help.next = node.next;
				}
			} else {
				help = node;
			}
			node = node.next;
		}
		return head;
	}
}
