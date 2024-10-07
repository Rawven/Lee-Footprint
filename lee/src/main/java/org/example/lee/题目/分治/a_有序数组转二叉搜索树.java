package org.example.lee.题目.分治;

import org.example.lee.model.TreeNode;

public class a_有序数组转二叉搜索树 {

	public TreeNode sortedArrayToBST(int[] nums) {
		int len = nums.length;
		return tool(nums, 0, len - 1);
	}

	TreeNode tool(int[] nums, int left, int right) {
		int index = (right + left) / 2;
		TreeNode treeNode = new TreeNode();
		treeNode.val = nums[index];
		if (index > left) {
			treeNode.left = tool(nums, left, index - 1);
		}
		if (index < right) {
			treeNode.right = tool(nums, index + 1, right);
		}
		return treeNode;
	}
}
