package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class b_把二叉搜索树转换为累加树 {

  public int help = 0;

  public TreeNode convertBST(TreeNode root) {
    tool(root);
    return root;
  }

  void tool(TreeNode node) {
    if (node == null) {
      return;
    }
    tool(node.right);
    node.val += help;
    help = node.val;
    tool(node.left);
  }
}
