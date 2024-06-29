package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class b_二叉搜索树中的插入操作 {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    TreeNode head = root;
    while (root != null) {
      if (root.val > val) {
        if (root.left == null) {
          root.left = new TreeNode(val);
          return head;
        }
        root = root.left;
      } else if (root.val < val) {
        if (root.right == null) {
          root.right = new TreeNode(val);
          return head;
        }
        root = root.right;
      }
    }
    return head;
  }
}
