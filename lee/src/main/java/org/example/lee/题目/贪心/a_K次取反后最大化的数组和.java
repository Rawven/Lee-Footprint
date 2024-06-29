package org.example.lee.题目.贪心;

import java.util.stream.IntStream;

public class a_K次取反后最大化的数组和 {

  public int largestSumAfterKNegations(int[] nums, int k) {
    nums = IntStream.of(nums)
        .boxed()
        .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
        .mapToInt(Integer::intValue).toArray();
    int min = 0, save = 0;
    for (int i = 0; i < nums.length && save < k; i++) {
      if (nums[i] < 0) {
        nums[i] *= -1;
        save++;
      }
      if (nums[min] > nums[i]) {
        min = i;
      }
    }
    if (save < k) {
      int h = k - save;
      if (h % 2 != 0) {
        nums[min] *= -1;
      }
    }
    int a = 0;
    for (int i : nums) {
      a += i;
    }
    return a;
  }
}
