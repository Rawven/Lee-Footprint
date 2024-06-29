package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.List;

public class b_非递减子序列 {

  public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    tool(list, new ArrayList<>(), 0, nums);
    return list;
  }

  void tool(List<List<Integer>> lists, List<Integer> list, int start, int[] nums) {
    if (list.size() >= 2) {
      lists.add(new ArrayList<>(list));
    }
    int[] arr = new int[201];
    for (int i = start; i < nums.length; i++) {
      if ((start != 0 && nums[start - 1] > nums[i]) || arr[nums[i] + 100] != 0) {
        continue;
      }
      arr[nums[i] + 100]++;
      list.add(nums[i]);
      tool(lists, list, i + 1, nums);
      list.remove(list.size() - 1);
    }
  }
}
