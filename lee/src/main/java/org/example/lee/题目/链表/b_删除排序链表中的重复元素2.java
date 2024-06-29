package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;

public class b_删除排序链表中的重复元素2 {

  /**
   * delete duplicates 运用头结点 可以做到无法想象的优化
   *
   * @param head head
   * @return {@link ListNode}
   */
  public static ListNode deleteDuplicates(ListNode head) {
    ListNode rh = new ListNode(0, head);
    head = rh;
    while (head.next != null && head.next.next != null) {
      if (head.next.val == head.next.next.val) {
        int i = head.next.val;
        while (head.next != null && head.next.val == i) {
          head.next = head.next.next;
        }
      } else {
        head = head.next;
      }
    }
    return rh.next;
  }
}
