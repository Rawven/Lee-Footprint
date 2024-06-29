package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class b_最大二叉树 {

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return tool(nums, 0, nums.length - 1);
  }

  public TreeNode tool(int[] nums, int start, int end) {
    if (start == end) {
      return new TreeNode(nums[end]);
    }
    if (start > end) {
      return null;
    }
    int maxP = start;
    for (int i = start + 1; i <= end; i++) {
      if (nums[maxP] < nums[i]) {
        maxP = i;
      }
    }
    TreeNode node = new TreeNode(nums[maxP]);
    node.left = tool(nums, start, maxP - 1);
    node.right = tool(nums, maxP + 1, end);
    return node;
  }
}
