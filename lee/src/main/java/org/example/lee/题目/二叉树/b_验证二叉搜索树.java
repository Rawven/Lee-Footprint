package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class b_验证二叉搜索树 {

  public TreeNode node;

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    boolean bst, bst1, bst2;
    bst = isValidBST(root.left);
    if (!bst) {
      return false;
    }
    if (node != null) {
      bst1 = root.val > node.val;
      if (!bst1) {
        return false;
      }
    }
    node = root;
    bst2 = isValidBST(root.right);
    return bst2;
  }
}
