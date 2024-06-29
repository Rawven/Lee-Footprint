package org.example.lee.题目.链表;

import java.util.HashMap;
import org.example.lee.model.ListNode;

public class b_旋转链表 {

  /**
   * rotate right 哈希表法
   *
   * @param head head
   * @param k    k
   * @return {@link ListNode}
   */
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k <= 0 || head.next == null) {
      return head;
    }
    ListNode fast;
    HashMap<Integer, ListNode> map = new HashMap<>();
    fast = head;
    int i = 0;
    while (fast != null) {
      map.put(i, fast);
      i++;
      fast = fast.next;
    }
    if (k % i == 0) {
      return head;
    }
    int real = i - k % i;
    ListNode listNode = map.get(i - 1);
    listNode.next = head;
    listNode = map.get(real - 1);
    listNode.next = null;
    return map.get(real);
  }
}
