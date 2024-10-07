package org.example.lee.题目.其它;

import org.example.lee.model.ListNode;

public class b_两两交换链表种的节点 {


	/**
	 * swap pairs 简单题
	 *
	 * @param head head
	 * @return {@link ListNode}
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode h;
		h = head.next;
		head.next = swapPairs(h.next);
		h.next = head;
		return h;
	}

}
