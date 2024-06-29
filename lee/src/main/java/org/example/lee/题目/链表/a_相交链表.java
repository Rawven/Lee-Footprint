package org.example.lee.题目.链表;

import java.util.HashSet;
import org.example.lee.model.ListNode;

public class a_相交链表 {

  /**
   * 简单理解为： 如链表A+链表B=链表C1 链表B+链表A=链表C2 A -> a1 a2 c1 c2 c3 B -> b1 b2 b3 c1 c2 c3 C1 -> a1 a2 c1 c2
   * c3 b1 b2 b3 c1 c2 c3 C2 -> b1 b2 b3 c1 c2 c3 a1 a2 c1 c2 c3 此时C1和C2的长度一定相同。 而C1和C2的结尾就一定是相交的链表。
   * 如果AB不相交则结尾都是null
   */
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
