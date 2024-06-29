package org.example.lee.题目.二叉树;

import java.util.ArrayList;
import java.util.List;
import org.example.lee.model.TreeNode;

public class a_二叉搜索树中的众数 {

  public int max = 0;
  public int save = Integer.MIN_VALUE;
  public int saveNow = 0;
  public List<Integer> list = new ArrayList<>();

  public int[] findMode(TreeNode root) {
    tool(root);
    int[] ints = new int[list.size()];
    int index = 0;
    for (Integer i : list) {
      ints[index++] = i;
    }
    return ints;
  }

  void tool(TreeNode root) {
    if (root == null) {
      return;
    }
    tool(root.left);
    if (save == Integer.MIN_VALUE || root.val == save) {
      saveNow++;
    } else {
      saveNow = 1;
    }
    if (saveNow >= max) {
      list.add(root.val);
      if (saveNow > max) {
        list.add(root.val);
        max = saveNow;
      }
    }
    save = root.val;
    tool(root.right);
  }

}
