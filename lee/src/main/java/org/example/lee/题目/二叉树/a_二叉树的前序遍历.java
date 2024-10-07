package org.example.lee.题目.二叉树;

import java.util.ArrayList;
import java.util.List;

import org.example.lee.model.TreeNode;

public class a_二叉树的前序遍历 {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		tool(root, list);
		return list;
	}

	void tool(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		list.add(node.val);
		tool(node.left, list);
		tool(node.right, list);
	}
}
