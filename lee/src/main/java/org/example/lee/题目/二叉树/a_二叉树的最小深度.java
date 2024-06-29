package org.example.lee.题目.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import org.example.lee.model.TreeNode;

public class a_二叉树的最小深度 {

  /**
   * min depth 层次遍历更快
   *
   * @param root root
   * @return int
   */
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    int key = 0;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      key++;
      for (int i = 0; i < size; i++) {
        TreeNode poll = queue.poll();
        if (poll.left == null && poll.right == null) {
          return key;
        }
        if (poll.left != null) {
          queue.add(poll.left);
        }
        if (poll.right != null) {
          queue.add(poll.right);
        }
      }
    }
    return 0;
  }

// 较慢的回溯方法
//    public  int answer = Integer.MAX_VALUE;
//    public  int key = 0;
//    public  int minDepth(TreeNode root) {
//        tool(root);
//        return answer;
//    }
//     void tool(TreeNode root){
//        if(root == null){
//            return;
//        }else {
//            key++;
//            if(root.left == null && root.right == null){
//                answer = Math.min(answer,key);
//            }else {
//                tool(root.left);
//                tool(root.right);
//            }
//            key--;
//        }
//    }
}
