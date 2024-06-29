package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

/**
 * a 对称二叉树
 *
 * @author 刘家辉
 * @date 2024/01/11
 */
public class a_对称二叉树 {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return tool(root.left, root.right);
  }

  public boolean tool(TreeNode a, TreeNode b) {
    if (a == null && b == null) {
      return true;
    }
    if (a == null || b == null || a.val != b.val) {
      return false;
    }
    return tool(a.left, b.right) && tool(a.right, b.left);
  }
}
