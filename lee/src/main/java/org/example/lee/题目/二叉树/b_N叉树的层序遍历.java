package org.example.lee.题目.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.example.lee.model.重名3.Node;

public class b_N叉树的层序遍历 {

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> list = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    if (root == null) {
      return list;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      Node poll = null;
      List<Integer> list1 = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        poll = queue.poll();
        queue.addAll(poll.children);
        list1.add(poll.val);
      }
      list.add(list1);
    }
    return list;
  }
}
