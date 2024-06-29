package org.example.lee.题目.动态规划;

public class a_买卖股票的最佳时机 {

  /**
   * max profit dp[i]
   *
   * @param prices prices
   * @return int
   */
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int min = prices[0], key = prices[1] - prices[0];
    for (int i = 1; i < prices.length; i++) {
      min = Math.min(min, prices[i]);
      key = Math.max(key, prices[i] - min);
    }
    return key;
  }
}
