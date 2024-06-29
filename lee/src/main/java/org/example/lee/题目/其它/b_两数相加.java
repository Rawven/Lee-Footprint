package org.example.lee.题目.其它;


import org.example.lee.model.ListNode;

public class b_两数相加 {

  /**
   * 给你两个 非空 的链表，表示两个非负的整数。 它们每位数字都是按照 逆序 的方式存储的， 并且每个节点只能存储 一位 数字。 请你将两个数相加，并以相同形式返回一个表示和的链表 add
   * two numbers
   *
   * @param l1 l1
   * @param l2 l2
   * @return {@link ListNode}
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode listNode = new ListNode(), head = listNode, parent = null;
    int total = 0, save = 0;
    while (l1 != null || l2 != null) {
      if (l1 != null) {
        total += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        total += l2.val;
        l2 = l2.next;
      }
      listNode.val += total;
      if (listNode.val > 9) {
        save = listNode.val / 10;
        listNode.val %= 10;
      }
      listNode.next = new ListNode();
      parent = listNode;
      listNode = listNode.next;
      listNode.val += save;
      total = 0;
      save = 0;
    }
    if (listNode.val == 0) {
      parent.next = null;
    }
    return head;
  }


}
