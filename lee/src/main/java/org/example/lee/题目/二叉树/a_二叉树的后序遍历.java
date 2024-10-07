package org.example.lee.题目.二叉树;

import java.util.ArrayList;
import java.util.List;

import org.example.lee.model.TreeNode;

public class a_二叉树的后序遍历 {

	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> objects = new ArrayList<>();
		tool(root, objects);
		return objects;
	}

	void tool(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		tool(node.left, list);
		tool(node.right, list);
		list.add(node.val);
	}
}
