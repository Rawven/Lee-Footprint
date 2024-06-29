package org.example.lee.题目.动态规划;

public class b_打家劫舍 {

  public int rob(int[] nums) {
    //dp[i] = 到该位置可以获得的最大金额
    int[] dp = new int[nums.length];
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    } else {
      dp[0] = nums[0];
      dp[1] = Math.max(nums[1], nums[0]);
      for (int i = 2; i < nums.length; i++) {
        dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
      }
      return dp[nums.length - 1];
    }
  }
}
