package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.List;

public class b_子集 {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    tool(list, new ArrayList<>(), 0, nums);
    return list;
  }

  void tool(List<List<Integer>> lists, List<Integer> list, int start, int[] nums) {
    lists.add(new ArrayList<>(list));

    for (int i = start; i < nums.length; i++) {
      list.add(nums[i]);
      tool(lists, list, i + 1, nums);
      list.remove(list.size() - 1);
    }
  }
}
