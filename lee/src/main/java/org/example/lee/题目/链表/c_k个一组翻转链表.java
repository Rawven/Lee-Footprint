package org.example.lee.题目.链表;

import org.example.lee.model.ListNode;

public class c_k个一组翻转链表 {


  /**
   * reverse kgroup 递归+倒序
   *
   * @param head head
   * @param k    k
   * @return {@link ListNode}
   */
  public static ListNode reverseKGroup(ListNode head, int k) {
    int i = 0;
    ListNode save = head, h, prev;
    while (i < k) {
      if (head == null) {
        return save;
      }
      head = head.next;
      i++;
    }
    i = 0;
    prev = head;
    head = save;
    while (i < k) {
      //TODO 头插法
      h = head.next;
      if (i == 0) {
        //根据情况递归
        head.next = reverseKGroup(prev, k);
      } else {
        head.next = prev;
      }
      prev = head;
      head = h;
      i++;
    }
    return prev;
  }
}
