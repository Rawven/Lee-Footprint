package org.example.lee.题目.二叉树;

import java.util.HashMap;

import org.example.lee.model.TreeNode;

/**
 * @author 刘家辉
 * @date 2024/01/11
 */
public class b_从前序与中序遍历序列构造二叉树 {

	public int index = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return tool(preorder, 0, preorder.length - 1, map);
	}

	public TreeNode tool(int[] preorder, int left, int right, HashMap<Integer, Integer> map) {

		if (left > right || index >= preorder.length) {
			return null;
		}
		TreeNode head = new TreeNode();
		head.val = preorder[index++];
		if (left == right) {
			return head;
		}
		int i = map.get(head.val);
		head.left = tool(preorder, left, i - 1, map);
		head.right = tool(preorder, i + 1, right, map);
		return head;
	}


}
