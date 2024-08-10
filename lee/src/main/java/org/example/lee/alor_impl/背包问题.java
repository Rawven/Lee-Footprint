package org.example.lee.alor_impl;

public class 背包问题 {

  public int knapsack(int[] weight, int[] value, int n, int w) {
    int[][] dp = new int[n][w + 1];
    for (int i = 0; i < n; i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i <= w; i++) {
      if (weight[0] <= i) {
        dp[0][i] = value[0];
      } else {
        dp[0][i] = 0;
      }
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= w; j++) {
        if (weight[i] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
        }
      }
    }
    return dp[n - 1][w];
  }
}
