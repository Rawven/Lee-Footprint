package org.example.lee.题目.链表;

import java.util.HashSet;

import org.example.lee.model.ListNode;

public class a_相交链表 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA, b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}

	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		HashSet<ListNode> map = new HashSet<>();
		while (headA != null) {
			map.add(headA);
			headA = headA.next;
		}
		while (headB != null) {
			if (map.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}
}
