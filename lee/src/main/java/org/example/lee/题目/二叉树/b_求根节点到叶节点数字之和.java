package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class b_求根节点到叶节点数字之和 {

	public int num = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			num *= 10;
			return 0;
		}
		num = num * 10 + root.val;
		if (root.right == null && root.left == null) {
			return num;
		}
		int i = sumNumbers(root.left);
		num = num / 10;
		int i1 = sumNumbers(root.right);
		num = num / 10;
		return i + i1;
	}

}
