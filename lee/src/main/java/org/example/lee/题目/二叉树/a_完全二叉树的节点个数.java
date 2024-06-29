package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

/**
 * a 完全二叉树节点个数 更快的写法 面试只会考进阶
 *
 * @author 刘家辉
 * @date 2024/03/03
 */
public class a_完全二叉树的节点个数 {

  public int num = 0;

  public int countNodes(TreeNode root) {
    fun(root);
    return num;
  }

  void fun(TreeNode root) {
    if (root == null) {
      return;
    }
    int leftHe = tool(root.left);
    int rightHe = tool(root.right);
    if (leftHe == rightHe) {
      num += (int) Math.pow(2, leftHe);
      fun(root.right);
    } else {
      num += (int) Math.pow(2, rightHe);
      fun(root.left);
    }
  }

  int tool(TreeNode treeNode) {
    int i = 0;
    while (treeNode != null) {
      treeNode = treeNode.left;
      i++;
    }
    return i;
  }
}
