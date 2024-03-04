package org.example.lee.题目.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.example.lee.model.TreeNode;

public class b_二叉搜索树迭代器 {
    class BSTIterator {
        public int key;
        public Queue<TreeNode> nodes = new LinkedList<>();
        public BSTIterator(TreeNode root) {
          tool(root);
        }
        private void tool(TreeNode root){
            if(root==null){
                return;
            }
            tool(root.left);
            nodes.add(root);
            tool(root.right);
        }

        public int next() {
            if(nodes.isEmpty()){
                return 0;
            }
           return nodes.poll ().val;
        }

        public boolean hasNext() {
           return !nodes.isEmpty();
        }
    }
}
