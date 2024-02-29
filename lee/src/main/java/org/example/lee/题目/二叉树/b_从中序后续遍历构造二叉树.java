package org.example.lee.题目.二叉树;

import java.util.Arrays;
import java.util.HashMap;
import org.example.lee.model.TreeNode;
import org.example.lee.util.LeeUtil;

public class b_从中序后续遍历构造二叉树 {
    public int rootIndex;
    public  TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int j = 0; j < len; j++) {
            map.put(inorder[j],j);
        }
        rootIndex = postorder.length-1;
        return tool(inorder,postorder,0,len-1,map);
    }
    TreeNode  tool(int[] inorder, int[] postorder,int begin,int end,HashMap<Integer,Integer> map){
        TreeNode treeNode = new TreeNode();
        if(begin>end){
            return null;
        }
        int root = postorder[rootIndex--];
        int mid = map.get(root);
        treeNode.val = root;
        treeNode.right = tool(inorder, postorder, mid + 1, end, map);
        treeNode.left = tool(inorder,postorder,begin,mid-1,map);
        return treeNode;
    }
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if(inorder.length<=1){
            if(inorder.length==0){
                return null;
            }
            TreeNode treeNode = new TreeNode();
            treeNode.val = inorder[0];
            return treeNode;
        }
        int len = inorder.length;
        int root = postorder[len-1];
        int i = 0;
        while(i<len){
            if(inorder[i]==root){
                break;
            }
            i++;
        }
        TreeNode treeNode = new TreeNode();
        treeNode.val = root;
        int[] leftI = Arrays.copyOfRange(inorder, 0, i);
        int[] rightI = Arrays.copyOfRange(inorder, i + 1, len);
        int[] leftP = Arrays.copyOfRange(postorder, 0, i);
        int[] rightP = Arrays.copyOfRange(postorder, i, len-1);
        treeNode.left=buildTree(leftI,leftP);
        treeNode.right=buildTree(rightI,rightP);
        return treeNode;
    }
}
