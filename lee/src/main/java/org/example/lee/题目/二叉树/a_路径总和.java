package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class a_路径总和 {

  public int num = 0;

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    num += root.val;
    if (root.right == null && root.left == null) {
      if (num == targetSum) {
        return true;
      }
    }
    if (root.left != null) {
      boolean b = hasPathSum(root.left, targetSum);
      if (b) {
        return true;
      }
      num -= root.left.val;
    }
    if (root.right != null) {
      boolean b1 = hasPathSum(root.right, targetSum);
      if (b1) {
        return true;
      }
      num -= root.right.val;
    }
    return false;
  }

}
