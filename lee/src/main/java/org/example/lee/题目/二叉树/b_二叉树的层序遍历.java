package org.example.lee.题目.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.example.lee.model.TreeNode;

public class b_二叉树的层序遍历 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return list;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeNode poll = null;
			List<Integer> list1 = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				poll = queue.poll();
				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
				list1.add(poll.val);
			}
			list.add(list1);
		}
		return list;
	}
}
