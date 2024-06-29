package org.example.lee.题目.动态规划;

import java.util.Arrays;

public class b_零钱兑换 {

  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    //dp[i]代表到i前的最小次数
    int[] dp = new int[amount + 1];
    Arrays.sort(coins);
    for (int i = 1; i <= amount; i++) {
      //提前赋值 注：dp[0]=0
      dp[i] = amount + 1;
      for (int j = 0; j < coins.length && i >= coins[j]; j++) {
        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  /**
   * coin change 自己写的
   *
   * @param coins  coins
   * @param amount amount
   * @return int
   */
  public int coinChange1(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    //dp[i]代表到i前的最小次数
    int[] dp = new int[amount + 1];
    Arrays.sort(coins);
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length && i >= coins[j]; j++) {
        int coin = coins[j];
        if (i - coin == 0 || dp[i - coin] != 0) {
          int a = dp[i - coin] + 1;
          dp[i] = dp[i] == 0 ? a : Math.min(dp[i], a);
        }
      }
    }
    return dp[amount] == 0 ? -1 : dp[amount];
  }
}
