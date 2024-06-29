package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class b_二叉树展开为链表 {

  /**
   * flatten 将左子树的最右边结点移到右子树，然后循环右节点
   *
   * @param root root
   */
  public void flatten(TreeNode root) {
    while (root != null) {
      if (root.left != null) {
        TreeNode left = root.left;
        while (left.right != null) {
          left = left.right;
        }

        left.right = root.right;
        root.right = root.left;
        root.left = null;
      }
      root = root.right;
    }
  }

}
