package org.example.lee.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.example.lee.model.ListNode;
import org.example.lee.model.TreeNode;

public class LeeUtil {

	public static int[][] getArray(String str) {
		str = str.replaceAll("\\[\\[", "").replaceAll("\\]\\]", "");
		String[] rows = str.split("\\],\\[");

		int[][] arr = new int[rows.length][];
		for (int i = 0; i < rows.length; i++) {
			arr[i] = Arrays.stream(rows[i].split(","))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		return arr;
	}

	public static void printArray(String str) {
		int[][] arr = getArray(str);

		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
	}


	public static TreeNode arrayToTreeNode(Integer[] integers) {
		//实现将一个Integer数组转换为二叉树 数组是按照层次遍历顺序给的元素
		if (integers == null || integers.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(integers[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int i = 1;
		while (i < integers.length) {
			TreeNode curr = queue.poll();
			if (integers[i] != null) {
				curr.left = new TreeNode(integers[i]);
				queue.offer(curr.left);
			}
			i++;
			if (i < integers.length && integers[i] != null) {
				curr.right = new TreeNode(integers[i]);
				queue.offer(curr.right);
			}
			i++;
		}
		return root;
	}

	public static ListNode arrayToListNode(int[] arr) {
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		for (int i : arr) {
			current.next = new ListNode(i);
			current = current.next;
		}
		return dummyHead.next;
	}
}
