package org.example.lee.题目.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class b_全排列2 {


  static void tool(LinkedList<Integer> queue, int start, List<List<Integer>> list,
      List<Integer> save, int len) {
    if (start == len) {
      list.add(new ArrayList<>(save));
    }
    int[] arr = new int[21];
    for (int i = start; i < len; i++) {
      if (arr[queue.peek() + 10] != 0) {
        queue.offer(queue.poll());
        continue;
      }
      Integer poll = queue.poll();
      arr[poll + 10]++;
      save.add(poll);
      tool(queue, start + 1, list, save, len);
      save.remove(save.size() - 1);
      queue.offer(poll);
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i : nums) {
      queue.offer(i);
    }
    tool(queue, 0, list, new ArrayList<>(), nums.length);
    return list;
  }
}
