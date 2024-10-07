package org.example.lee.题目.二叉树;

import java.util.ArrayList;
import java.util.List;

import org.example.lee.model.TreeNode;

public class a_二叉树的所有路径 {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		if (root != null) {
			sb.append(root.val);
			if (root.left == null && root.right == null) {
				list.add(sb.toString());
			} else {
				tool(root.left, list, sb);
				tool(root.right, list, sb);
			}
		}
		return list;
	}

	void tool(TreeNode node, List<String> list, StringBuilder sb) {
		if (node == null) {
			return;
		}
		sb.append("->");
		sb.append(node.val);
		if (node.left == null && node.right == null) {
			list.add(sb.toString());
		} else {
			tool(node.left, list, new StringBuilder(sb));
			tool(node.right, list, new StringBuilder(sb));
		}
	}
}
