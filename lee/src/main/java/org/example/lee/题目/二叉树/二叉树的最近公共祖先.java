package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

/**
 * 二叉树最近公共祖先
 *
 * @author 刘家辉
 * @date 2024/03/03
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == q || root == p){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null&&right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        return right;
    }

}
