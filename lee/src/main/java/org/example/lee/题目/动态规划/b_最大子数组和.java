package org.example.lee.题目.动态规划;

public class b_最大子数组和 {

  public int maxSubArray(int[] nums) {
    int h = 0, max = Integer.MIN_VALUE;
    for (int k : nums) {
      h += k;
      max = Math.max(max, h);
      if (h < 0) {
        h = 0;
      }
    }
    return max;
  }

}
