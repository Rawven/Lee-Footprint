package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;

public class b_环形链表Ⅱ {

	/**
	 * detect cycle
	 * https://www.programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E6%80%9D%E8%B7%AF
	 * 数学题 需要自己列一下相关式子 然后就能推导出结论
	 *
	 * @param head head
	 * @return {@link ListNode}
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		ListNode a = head.next, b = head.next.next;
		while (a != null && b != null && b.next != null && a != b) {
			b = b.next.next;
			a = a.next;
		}
		if (a == null || b == null || b.next == null) {
			return null;
		}
		while (head != a) {
			head = head.next;
			a = a.next;
		}
		return a;
	}
}
