package org.example.lee.题目.分治;

import org.example.lee.model.ListNode;

public class b_排序链表 {

	public ListNode sortList(ListNode head) {
		return tool(head);
	}

	ListNode tool(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}
		//cut
		ListNode fast = node, slow = node, save;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		save = slow.next;
		slow.next = null;
		//递归
		ListNode left = tool(node);
		ListNode right = tool(save);
		//merge
		ListNode head = new ListNode(0);
		ListNode save2 = head;
		while (left != null && right != null) {
			if (left.val < right.val) {
				head.next = left;
				left = left.next;
			} else {
				head.next = right;
				right = right.next;
			}
			head = head.next;
		}
		if (left != null) {
			head.next = left;
		} else {
			head.next = right;
		}
		return save2;
	}
}
