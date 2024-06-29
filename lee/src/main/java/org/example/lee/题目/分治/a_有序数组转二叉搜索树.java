package org.example.lee.题目.分治;

import org.example.lee.model.TreeNode;

public class a_有序数组转二叉搜索树 {

  public static void main(String[] args) {
    sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
  }

  public static TreeNode sortedArrayToBST(int[] nums) {
    int len = nums.length;
    return tool(nums, 0, len - 1);
  }

  static TreeNode tool(int[] nums, int left, int right) {
    int index = (right + left) / 2;
    TreeNode treeNode = new TreeNode();
    treeNode.val = nums[index];
    if (index - 1 > left) {
      treeNode.left = tool(nums, left, index - 1);
    } else if (left == index - 1) {
      TreeNode treeNode1 = new TreeNode();
      treeNode1.val = nums[left];
      treeNode.left = treeNode1;
    }
    if (right > index + 1) {
      treeNode.right = tool(nums, index + 1, right);
    } else if (right == index + 1) {
      TreeNode treeNode1 = new TreeNode();
      treeNode1.val = nums[right];
      treeNode.right = treeNode1;
    }
    return treeNode;
  }
}
