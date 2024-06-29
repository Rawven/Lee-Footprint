package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

/**
 * a 二叉树最大深度
 *
 * @author 刘家辉
 * @date 2024/01/11
 */
public class a_二叉树的最大深度 {

  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode();
    TreeNode treeNode2 = new TreeNode();
    treeNode2.val = 2;
    treeNode1.val = 1;
    TreeNode treeNode = new TreeNode();
    treeNode.val = 0;
    treeNode.left = treeNode1;
    treeNode.right = treeNode2;
    maxDepth(treeNode);
  }


  public static int maxDepth(TreeNode root) {
    int max = 0;
    return tool(root, max, 0);
  }

  public static int tool(TreeNode node, int max, int now) {
    if (node == null) {
      return Math.max(max, now);
    }
    int tool = tool(node.left, max, now + 1);
    int tool1 = tool(node.right, max, now + 1);
    return Math.max(tool, tool1);
  }
}
