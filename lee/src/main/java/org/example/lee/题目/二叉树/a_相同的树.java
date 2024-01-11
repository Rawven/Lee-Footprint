package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class a_相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if( p==null||q==null||p.val != q.val){
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}
