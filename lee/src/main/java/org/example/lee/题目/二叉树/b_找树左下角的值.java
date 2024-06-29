package org.example.lee.题目.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import org.example.lee.model.TreeNode;

public class b_找树左下角的值 {

  public int findBottomLeftValue(TreeNode root) {
    int key = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) {
      return 0;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      TreeNode poll = null;
      key = queue.peek().val;
      for (int i = 0; i < size; i++) {
        poll = queue.poll();
        if (poll.left != null) {
          queue.add(poll.left);
        }
        if (poll.right != null) {
          queue.add(poll.right);
        }
      }
    }
    return key;
  }

}
