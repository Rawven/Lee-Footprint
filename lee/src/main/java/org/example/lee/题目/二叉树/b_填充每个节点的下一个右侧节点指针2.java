package org.example.lee.题目.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import org.example.lee.model.重名2.Node;

public class b_填充每个节点的下一个右侧节点指针2 {

  //进阶 O(1)  提前连下一层
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Node queue = new Node();
    Node help = new Node(), save;
    queue.next = root;
    while (queue.next != null) {
      Node p = queue.next;
      save = help;
      while (p != null) {
        if (p.left != null) {
          save.next = p.left;
          save = save.next;
        }
        if (p.right != null) {
          save.next = p.right;
          save = save.next;
        }
        p = p.next;
      }
      queue.next = help.next;
      //重置
      help.next = null;
    }
    return root;
  }

  //给的是任意二叉树
  public Node connect1(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    Node node = null;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        node = queue.poll();
        node.next = queue.peek();
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      node.next = null;
    }
    return root;
  }
}