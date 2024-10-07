package org.example.lee.题目.二叉树;

import java.util.LinkedList;
import java.util.Queue;

import org.example.lee.model.重名2.Node;

public class b_填充每个节点的下一个右侧节点指针 {
	//给的是完美二叉树

	//进阶 递归双100%
	public Node connect(Node root) {
		if (root.left != null) {
			root.left.next = root.right;
			if (root.next != null) {
				root.right.next = root.next.left;
			}
		}
		connect(root.left);
		connect(root.right);
		return root;
	}

	//快1ms
	public Node connect2(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node node = null;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				node = queue.poll();
				node.next = queue.peek();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			node.next = null;
		}
		return root;
	}

	//慢方法
	public Node connect1(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node node;
		while (queue != null) {
			node = queue.poll();
			if (queue.isEmpty()) {
				node.next = null;
			} else {
				node.next = queue.peek();
			}
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			if (node.next == null) {
				queue.add(null);
			}
		}
		return root;
	}
}
