package org.example.lee.题目.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.example.lee.model.TreeNode;

public class b_二叉树锯齿层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return list;
        }
        boolean a =false;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode poll = null;
            LinkedList<Integer> arr = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                poll = queue.poll();
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
                if(!a) {
                    arr.addFirst(poll.val);
                }else {
                    arr.addLast(poll.val);
                }
            }
            a=!a;
            list.add(arr);
        }
        return list;
    }
}
