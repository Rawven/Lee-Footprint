package org.example.lee.题目.二叉树;

import org.example.lee.model.TreeNode;

public class b_删除二叉搜索树中的节点 {

  public TreeNode deleteNode(TreeNode root, int key) {
    TreeNode parent = null, head = root, node;
    while (root != null) {
      if (root.val == key) {
        node = root.right != null ? root.right : root.left;
        if (parent == null) {
          head = node;
        } else if (parent.left == root) {
          parent.left = node;
        } else {
          parent.right = node;
        }
        node = root.right;
        while (node != null) {
          if (node.left == null) {
            node.left = root.left;
            break;
          }
          node = node.left;
        }
        break;
      }
      parent = root;
      root = root.val > key ? root.left : root.right;
    }
    return head;
  }
}
