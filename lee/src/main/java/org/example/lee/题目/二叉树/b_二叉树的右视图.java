package org.example.lee.题目.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.example.lee.model.TreeNode;

public class b_二叉树的右视图 {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return list;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeNode poll = null;
			for (int i = 0; i < size; i++) {
				poll = queue.poll();
				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
			}
			list.add(poll.val);
		}
		return list;
	}
}
