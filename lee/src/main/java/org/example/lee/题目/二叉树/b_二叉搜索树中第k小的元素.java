package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class b_二叉搜索树中第k小的元素 {

    public int num = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = tool(root,k);
        return node.val;
    }
    TreeNode tool(TreeNode root,int k){
        if(root == null){
            return null;
        }
        TreeNode a =  tool(root.left,k);
        if(a!=null){
            return a;
        }
        num++;
        if(num == k){
            return root;
        }
        a =tool(root.right,k);
        return a;
    }
}
