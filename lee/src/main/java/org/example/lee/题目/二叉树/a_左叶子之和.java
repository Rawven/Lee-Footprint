package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class a_左叶子之和 {

	public int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		tool(root.left, 1);
		tool(root.right, 2);
		return sum;
	}

	void tool(TreeNode node, int leftOrRight) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (leftOrRight == 1) {
				sum += node.val;
			}
			return;
		}
		tool(node.left, 1);
		tool(node.right, 2);
	}
}
