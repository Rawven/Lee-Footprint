package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b_子集Ⅱ {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    tool(list, new ArrayList<>(), 0, nums);
    return list;
  }

  void tool(List<List<Integer>> lists, List<Integer> list, int start, int[] nums) {
    lists.add(new ArrayList<>(list));
    int save = 11;
    for (int i = start; i < nums.length; i++) {
      if (save == nums[i]) {
        continue;
      }
      save = nums[i];
      list.add(nums[i]);
      tool(lists, list, i + 1, nums);
      list.remove(list.size() - 1);
    }
  }
}
