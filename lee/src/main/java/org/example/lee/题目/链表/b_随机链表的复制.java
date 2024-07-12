package org.example.lee.题目.链表;

import java.util.HashMap;
import org.example.lee.model.重名.Node;

public class b_随机链表的复制 {

  /**
   * copy random list 轻松拿下
   *
   * @param head head
   * @return {@link Node}
   */
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    HashMap<Node, Node> map2 = new HashMap<>();
    Node node = new Node(head.val);
    Node save = node, save1 = head;
    map2.put(head, node);
    head = head.next;
    while (head != null) {
      node = new Node(head.val);
      map2.put(head, node);
      head = head.next;
    }
    while (save1 != null) {
      Node node2 = map2.get(save1);
      node2.next = map2.get(save1.next);
      node2.random = map2.get(save1.random);
      save1 = save1.next;
    }
    return save;
  }
}
