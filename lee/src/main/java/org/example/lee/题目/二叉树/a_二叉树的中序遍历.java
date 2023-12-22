package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * a 二叉树中序遍历
 *
 * @author 刘家辉
 * @date 2023/12/02
 */
public class a_二叉树的中序遍历 {


    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        tool(list,root);
        return list;
    }
    public void tool(List<Integer> list,TreeNode root){
          if(root == null){
              return;
          }
          tool(list,root.left);
          list.add(root.val);
          tool(list,root.right);
    }
}
