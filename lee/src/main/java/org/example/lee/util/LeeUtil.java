package org.example.lee.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.example.lee.model.ListNode;
import org.example.lee.model.TreeNode;

public class LeeUtil {
    public static int[][] getArray(String str){
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


    public static TreeNode arrayToTreeNode(int[] integers) {
        //实现将一个int数组转换为二叉树 数组是按照层次遍历顺序给的元素
        if (integers.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(integers[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < integers.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (integers[i] != -1) {
                    node.left = new TreeNode(integers[i]);
                    queue.add(node.left);
                }
                isLeft = false;
            } else {
                if (integers[i] != -1) {
                    node.right = new TreeNode(integers[i]);
                    queue.add(node.right);
                }
                queue.poll();
                isLeft = true;
            }
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
