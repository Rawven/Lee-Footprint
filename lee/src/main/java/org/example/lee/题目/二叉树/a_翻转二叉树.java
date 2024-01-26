package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class a_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        tool(root);
        return root;
    }

    void tool(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode treeNode;
        treeNode = root.right;
        root.right = root.left;
        root.left = treeNode;
        tool(root.left);
        tool(root.right);
    }
}
