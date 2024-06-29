package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class a_平衡二叉树 {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    return tool(root) != -1;
  }

  int tool(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int tool = tool(node.left);
    if (tool == -1) {
      return -1;
    }
    int tool1 = tool(node.right);
    if (tool1 == -1) {
      return -1;
    }
    return Math.abs(tool1 - tool) > 1 ? -1 : 1 + Math.max(tool1, tool);
  }

}
