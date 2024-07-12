package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * b 组合总和
 *
 * @author 刘家辉
 * @date 2023/11/29
 */
public class b_组合总和 {

  public void main(String[] args) {
    combinationSum(new int[]{2, 3, 6, 7}, 7);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int length = candidates.length;
    //排序 方便 49行剪枝
    Arrays.sort(candidates);
    tool(lists, list, 0, 0, candidates, target, 0, length);
    return lists;
  }

  public void tool(List<List<Integer>> saveL, List<Integer> save,
      int initNum, int index, int[] candidates, int target, int begin, int len) {
    if (initNum == target) {
      ArrayList<Integer> list = new ArrayList<>(save);
      saveL.add(list);
      return;
    }
    for (int i = begin; i < len; i++) {
      int i1 = candidates[i];
      initNum += i1;
      if (initNum > target) {
        return;
      }
      save.add(index, i1);
      tool(saveL, save, initNum, index + 1, candidates, target, i, len);
      initNum -= i1;
      save.remove(index);
    }
  }
}
