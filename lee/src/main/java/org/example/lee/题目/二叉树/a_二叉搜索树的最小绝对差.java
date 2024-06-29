package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class a_二叉搜索树的最小绝对差 {

  public TreeNode save;
  public double answer = Math.pow(10, 5);

  /**
   * get minimum difference 中序遍历
   *
   * @param root root
   * @return int
   */
  public int getMinimumDifference(TreeNode root) {
    tool(root);
    return (int) answer;
  }

  void tool(TreeNode root) {
    if (root == null) {
      return;
    }
    tool(root.left);
    //用save始终保存中序遍历里的最近一个元素
    if (save != null) {
      answer = Math.min(Math.abs(root.val - save.val), answer);
    }
    save = root;
    tool(root.right);
  }

}
