package org.example.lee;

import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

  public static int maxProduct(int[] nums) {
    int[] dp = new int[nums.length];
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      int help = 1;
      for (int j = i; j >= 0; j--) {
        help *= nums[i];
        if (help > 0) {
          dp[i] = Math.max(dp[i], help);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  public static void main(String[] args) {
    maxProduct(new int[]{2, 3, -2, 4});
  }

}
