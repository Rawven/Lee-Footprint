package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;

public class b_反转链表2 {


	/**
	 * reverse between 反转链表+头尾处理
	 *
	 * @param head  head
	 * @param left  left
	 * @param right right
	 * @return {@link ListNode}
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || head.next == null || left >= right) {
			return head;
		}
		ListNode realH = head, l, f, s = null, h, e = null;
		int i = 1;
		while (i < left) {
			s = head;
			head = head.next;
			i++;
		}
		l = s;
		f = head;
		while (i < right) {
			h = head.next;
			head.next = e;
			e = head;
			head = h;
			i++;
		}
		f.next = head.next;
		head.next = e;
		if (l != null) {
			l.next = head;
			return realH;
		}
		return head;
	}


}
