package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;
import org.example.lee.util.LeeUtil;

public class c_二叉树中的最大路径和 {
    public static void main(String[] args) {
        maxPathSum(LeeUtil.arrayToTreeNode(new Integer[]{-10,9,20,null,null,15,7}));
    }

    public static int save=0;

    /**
     * max path sum
     * 正常写法
     * @param root root
     * @return int
     */
    public static int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        save = root.val;
     return Math.max(tool(root),save);
    }
    static int tool(TreeNode root){
        if(root.left!=null&&root.right!=null) {
            int left = tool(root.left);
            int right = tool(root.right);
            save = Math.max(save, Math.max(Math.max(root.val + left + right, left), right));
            return Math.max(right + root.val, Math.max(root.val + left, root.val));
        }else if(root.left!=null){
            int left = tool(root.left);
            save = Math.max(save, left);
            return Math.max(left+root.val, root.val);
        }else if(root.right!=null){
            int right = tool(root.right);
            save = Math.max(save, right);
            return Math.max(right+root.val, root.val);
        }
        save = Math.max(save,root.val);
        return root.val;
    }

    /**
     * max path sum1
     * 投机写法
     * @param root root
     * @return int
     */
    public int maxPathSum1(TreeNode root) {
        if(root == null){
            return 0;
        }
        save = root.val;
        return Math.max(tool1(root),save);
    }
    int tool1(TreeNode root){
        if(root == null){
            return -1001;
        }
        if(root.left==null&&root.right==null){
            save = Math.max(save,root.val);
            return root.val;
        }
        int left  = tool(root.left);
        int right = tool(root.right);
        save = Math.max(save,Math.max(Math.max(root.val + left + right, left), right));
        return Math.max(right+root.val,Math.max(root.val+left,root.val));
    }
}
