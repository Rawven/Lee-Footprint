package org.example.lee.题目.分治;

import org.example.lee.model.ListNode;

public class b_排序链表 {

  public ListNode sortList(ListNode head) {
    return tool(head);
  }

  ListNode tool(ListNode node) {
    int index = 0;
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
    ListNode tool = tool(node);
    ListNode tool1 = tool(save);
    //merge
    ListNode head = new ListNode(0);
    ListNode save2 = head;
    while (tool != null && tool1 != null) {
      if (tool.val < tool1.val) {
        head.next = tool;
        tool = tool.next;
      } else {
        head.next = tool1;
        tool1 = tool1.next;
      }
      head = head.next;
    }
    if (tool != null) {
      head.next = tool;
    } else {
      head.next = tool1;
    }
    return save2;
  }
}
